package baekjoon.dp.q4811;

import java.util.Scanner;

public class Main {

	static long[][] dp = new long[31][31];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			int N = input.nextInt();
			if(N == 0)
				break;
			System.out.println(cal(N, 0));
		}
		input.close();
	}
	
	private static long cal(int F, int H) {
		if(dp[F][H] != 0)
			return dp[F][H];
		if(F == 0)
			return 1;
		if(H == 0) 
			return dp[F][H] = cal(F - 1, H + 1);
		return dp[F][H] = cal(F - 1, H + 1) + cal(F, H - 1);
	}

}
