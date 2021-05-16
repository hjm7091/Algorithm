package Baekjoon.BruteForce.q2143;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static int T, n, m;
	static int[] A, B;
	static List<Integer> first = new ArrayList<>();
	static List<Integer> second = new ArrayList<>();
	
	public static void main(String[] args) {
		init();
		System.out.println(findAnswer());
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		T = input.nextInt();
		n = input.nextInt();
		A = new int[n];
		for(int i = 0; i < n; i++) 
			A[i] = input.nextInt();
		m = input.nextInt();
		B = new int[m];
		for(int i = 0; i < m; i++)
			B[i] = input.nextInt();
		
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = i; j < n; j++) {
				sum += A[j];
				first.add(sum);
			}
		}
		
		for(int i = 0; i < m; i++) {
			int sum = 0;
			for(int j = i; j < m; j++) {
				sum += B[j];
				second.add(sum);
			}
		}
		input.close();
	}
	
	private static long findAnswer() {
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : second) {
			if(map.containsKey(num)) 
				map.put(num, map.get(num)+1);
			else
				map.put(num, 1);
		}
		long result = 0;
		for(int num : first) {
			if(map.containsKey(T - num)) {
				result += map.get(T - num);
			}
		}
		return result;
	}

}
