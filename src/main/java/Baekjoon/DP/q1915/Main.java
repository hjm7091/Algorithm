package Baekjoon.DP.q1915;

import java.util.Scanner;

public class Main {
	
	static int[][] map, dp;
	static int n, m;
	static int result;
	
	public static void main(String[] args) {
		init();
		findAnswer();
		System.out.println(result * result);
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		map = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			String str = input.next();
			for(int j = 0; j < str.length(); j++) {
				map[i][j+1] = str.charAt(j) - '0';
			}
		}
		input.close();
	}
	
	private static void findAnswer() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] == 0)
					continue;
				dp[i][j] = getMin(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
				result = Integer.max(result, dp[i][j]);
			}
		}
	}
	
	private static int getMin(int a, int b, int c) {
		return Integer.min(Integer.min(a, b), c);
	}
}
