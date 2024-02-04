package baekjoon.dp.q2008;

import java.util.Scanner;

public class Main {

	static int N, M;
	static int start, end;
	static int addCost, delCost;
	static int[] p = new int[501];
	static int[][] dp = new int[501][501];
	
	public static void main(String[] args) {
		init();
		go();
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		start = input.nextInt();
		end = input.nextInt();
		delCost = input.nextInt();
		addCost = input.nextInt();
		for(int i = 1; i <= M; i++) {
			p[i] = input.nextInt();
		}
		for(int i = 1; i <= M; i++) {
			for(int j = 1; j <= N; j++)
				dp[i][j] = Integer.MAX_VALUE;
		}
		input.close();
	}
	
	private static void go() {
		for(int i = 1; i <= N; i++) {
			if(i == start)
				dp[0][i] = 0;
			else
				dp[0][i] = Math.abs(start - i) * addCost;
		}
		
		for(int i = 1; i <= M; i++) {
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= N; k++) {
					if(k == j && (p[i] == k || p[i] + 1 == k)) {
						if(dp[i][j] > dp[i-1][k] + delCost)
							dp[i][j] = dp[i-1][k] + delCost;
					} else if((k <= p[i] && p[i] <= j-1) || (j <= p[i] && p[i] <= k-1)) {
						if(dp[i][j] > dp[i-1][k] + (Math.abs(k-j)-1) * addCost)
							dp[i][j] = dp[i-1][k] + (Math.abs(k-j)-1) * addCost;
					} else {
						if(dp[i][j] > dp[i-1][k] + Math.abs(k-j) * addCost)
							dp[i][j] = dp[i-1][k] + Math.abs(k-j) * addCost;
					}
				}
			}
		}
		
		System.out.println(dp[M][end]);
	}

}
