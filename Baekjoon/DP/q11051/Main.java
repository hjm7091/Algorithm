package q11051;

import java.util.Scanner;

public class Main {

	static int N, K;
	static long[][] dp = new long[1001][1001];
	
	public static void main(String[] args) {
		init();
		System.out.println(go(N, K));
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		input.close();
	}
	
	private static long go(int n, int k) {
		if(n == k || k == 0) {
			dp[n][k] = 1;
			return dp[n][k];
		}
		if(dp[n][k] != 0)
			return dp[n][k];
		dp[n][k] = (go(n - 1, k - 1) + go(n - 1, k)) % 10007;
		return dp[n][k];
	}
}
