package q1937;

import java.util.Scanner;

public class Main {

	static int N;
	static int[][] forest;
	static int[][] dp;
	static int result;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		init();
		for(int x = 0; x < N; x++) 
			for(int y = 0; y < N; y++) 
				result = Integer.max(result, dfs(x, y));
		System.out.println(result);
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		forest = new int[N][N];
		dp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				forest[i][j] = input.nextInt();
				dp[i][j] = -1;
			}
		}
		input.close();
	}
	
	private static int dfs(int x, int y) {
		if(dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 1;
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(checkRangeOver(nx, ny))
				continue;
			if(forest[x][y] >= forest[nx][ny])
				continue;
			dp[x][y] = Integer.max(dp[x][y], dfs(nx, ny) + 1);
		}
		return dp[x][y];
	}
	
	private static boolean checkRangeOver(int x, int y) {
		if(x < 0 || x > N-1 || y < 0 || y > N-1)
			return true;
		return false;
	}

}
