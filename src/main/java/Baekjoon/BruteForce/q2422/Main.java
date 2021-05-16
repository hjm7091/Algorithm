package Baekjoon.BruteForce.q2422;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int N,M;
	static boolean[] check;
	static boolean[][] visit;
	static ArrayList<Integer> combination = new ArrayList<Integer>();
	static int result; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = bufferedReader.readLine().trim().split(" ");
		N = Integer.parseInt(firstLine[0]);
		M = Integer.parseInt(firstLine[1]);
		check = new boolean[N+1];
		visit = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			String[] line = bufferedReader.readLine().trim().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			visit[a][b] = true;
			visit[b][a] = true;
		}
		makeCombination(1, 0);
		System.out.println(result);
	}
	
	static public void makeCombination(int n, int cnt) {
		if(cnt==3) {
			if(canEat()) {
				result++;
			}
			return;
		}
		for(int i=n; i<=N; i++) {
			if(!check[i]) {
				check[i] = true;
				combination.add(i);
				makeCombination(i, cnt+1);
				combination.remove(combination.size()-1);
				check[i] = false;
			}
		}
	}
	
	static public boolean canEat() {
		int a = combination.get(0);
		int b = combination.get(1);
		int c = combination.get(2);
		if(visit[a][b] || visit[b][c] || visit[a][c])
			return false;
		return true;
	}
	
}
