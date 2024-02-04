package baekjoon.dp.q12872;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static final int mod = 1000000007;
	static int N, M, P;
	static long[][] dp = new long[101][101];
	
	public static void main(String[] args) {
		init();
		System.out.println(go(0, 0));
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		P = input.nextInt();
		for(int i = 0; i < 101; i++)
			Arrays.fill(dp[i], -1);
		input.close();
	}
	
	private static long go(int pos, int X) {
		int Y = N - X;
		if(pos == P) {
			if(Y == 0)
				return 1;
			else
				return 0;
		}
		if(dp[pos][X] != -1)
			return dp[pos][X];
		long tmp = 0;
		if(Y > 0)
			tmp += go(pos + 1, X + 1) * Y;
		if(X > M)
			tmp += go(pos + 1, X) * (X - M);
		dp[pos][X] = tmp % mod;
		return dp[pos][X];
	}

}
