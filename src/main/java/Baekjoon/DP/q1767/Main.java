package Baekjoon.DP.q1767;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static final int mod = 1000001;
	static int N, M, K;
	static long[][][] dp = new long[101][101][101];
	
	public static void main(String[] args) {
		init();
		System.out.println(go(N, M, K));
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		K = input.nextInt();
		for(int i = 0; i < 101; i++)
			for(int j = 0; j < 101; j++)
				Arrays.fill(dp[i][j], -1);
		input.close();
	}
	
	private static long go(int N, int M, int K) {
		if(K == 0)
			return 1;
		if(N < 1 || M < 1 || K < 0)
			return 0;
		if(dp[N][M][K] != -1)
			return dp[N][M][K];
		long result = 0;
		result += go(N-1, M, K) + go(N-1, M-1, K-1) * M;
		result += go(N-1, M-2, K-2) * M * (M-1) / 2;
		result += go(N-2, M-1, K-2) * M * (N-1);
		result %= mod;
		dp[N][M][K] = result;
		return result;
	}

}
