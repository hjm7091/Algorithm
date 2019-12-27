package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Q2422 {

	static int N,M;
	static boolean[] check;
	static ArrayList<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>();
	static ArrayList<Integer> combination = new ArrayList<Integer>();
	static int result; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = bufferedReader.readLine().trim().split(" ");
		N = Integer.parseInt(firstLine[0]);
		M = Integer.parseInt(firstLine[1]);
		check = new boolean[N+1];
		for(int i=0; i<M; i++) {
			String[] line = bufferedReader.readLine().trim().split(" ");
			HashSet<Integer> set = new HashSet<Integer>();
			for(String s : line) {
				set.add(Integer.parseInt(s));
			}
			sets.add(set);
		}
		makeCombination(1);
		System.out.println(result);
	}
	
	static public void makeCombination(int n) {
		if(combination.size()==3) {
			HashSet<Integer> nowSet = new HashSet<Integer>();
			for(int num : combination) {
				nowSet.add(num);
			}
			if(check(nowSet)) {
				System.out.println(nowSet);
				result++;
			}
			return;
		}
		for(int i=n; i<=N; i++) {
			if(!check[i]) {
				check[i] = true;
				combination.add(i);
				makeCombination(i);
				combination.remove(combination.size()-1);
				check[i] = false;
			}
		}
	}
	
	static public boolean check(HashSet<Integer> nowSet) {
		for(HashSet<Integer> set : sets) {
			if(nowSet.containsAll(set))
				return false;
		}
		return true;
	}
	
}
