package q12869;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] scv = new int[3];
	static int[][][] dp = new int[61][61][61];
	static final int INF = 987654321;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		for(int i=0; i<N; i++)
			scv[i] = input.nextInt();
		for(int a=0; a<61; a++)
			for(int b=0; b<61; b++)
				for(int c=0; c<61; c++)
					dp[a][b][c] = INF;
		System.out.println(find(scv[0], scv[1], scv[2]));
		input.close();
	}
	
	public static int find(int a, int b, int c) {
		
		a = a < 0 ? 0 : a;
		b = b < 0 ? 0 : b;
		c = c < 0 ? 0 : c;
		
		if(a==0 && b==0 && c==0) {
			return 0;
		}
		
		if(dp[a][b][c]!=INF) 
			return dp[a][b][c];
		
		dp[a][b][c] = Integer.min(dp[a][b][c], find(a-9, b-3, c-1)+1);
		dp[a][b][c] = Integer.min(dp[a][b][c], find(a-9, b-1, c-3)+1);
		dp[a][b][c] = Integer.min(dp[a][b][c], find(a-3, b-9, c-1)+1);
		dp[a][b][c] = Integer.min(dp[a][b][c], find(a-1, b-9, c-3)+1);
		dp[a][b][c] = Integer.min(dp[a][b][c], find(a-1, b-3, c-9)+1);
		dp[a][b][c] = Integer.min(dp[a][b][c], find(a-3, b-1, c-9)+1);
		
		return dp[a][b][c];
	}

}
