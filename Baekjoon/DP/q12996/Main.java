package q12996;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static final int mod = 1000000007;
	static int S, a, b, c;                    
	static long[][][][] dp = new long[51][51][51][51];
	/*dp[S][a][b][c] = 곡의 총 개수가 S개이고 각 멤버마다 불러야하는 곡의 수가 a, b, c개 일때,
	                   만들 수 있는 앨범 방법의 수 저장   */
	
	public static void main(String[] args) {
		init();
		System.out.println(findAnswer(S, a, b, c));
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		S = input.nextInt();
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		
		for(int i = 0; i <= S; i++) 
			for(int j = 0; j <= a; j++) 
				for(int k = 0; k <= b; k++) 
					Arrays.fill(dp[i][j][k], -1);
		
		input.close();
	}
	
	private static long findAnswer(int S, int a, int b, int c) {
		if(S == 0) {
			if(a == 0 && b == 0 && c == 0) 
				return 1;	
			else 
				return 0;
		}
		
		if(a < 0 || b < 0 || c < 0)
			return 0;
		
		if(dp[S][a][b][c] != -1)
			return dp[S][a][b][c];
		
		long cnt = 0;
		
		for(int i = 0; i <= 1; i++) 
			for(int j = 0; j <= 1; j++) 
				for(int k = 0; k <= 1; k++)
					if(i+j+k >= 1)
						cnt += findAnswer(S-1, a-i, b-j, c-k);
		
		cnt %= mod;
		dp[S][a][b][c] = cnt;
		
		return dp[S][a][b][c];
	}

}
