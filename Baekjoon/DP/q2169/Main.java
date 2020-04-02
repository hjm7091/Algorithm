package q2169;

import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] dp; //(x, y)까지 오는데 탐사한 지역들의 가치의 최대값
	static int[] left; //위쪽과 왼쪽에서 오는 방향 비교
	static int[] right; //위쪽과 오른쪽에서 오는 방향 비교
	
	public static void main(String[] args) {
		init();
		bottomUp();
		System.out.println(dp[N-1][M-1]);
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		map = new int[N][M];
		dp = new int[N][M];
		left = new int[M];
		right = new int[M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = input.nextInt();
			}
		}
		input.close();
	}
	
	private static void bottomUp() {
		
		//첫번째 행 처리
		dp[0][0] = map[0][0];
		for(int x = 0, y = 1; y < M; y++) {
			dp[x][y] = dp[x][y-1] + map[x][y];
		}
		
		for(int x = 1; x < N; x++) {
			
			//위쪽에서 내려왔을 때를 left, right에 각각 저장
			for(int y = 0; y < M; y++) {
				left[y] = right[y] = dp[x-1][y] + map[x][y];
			}
			
			//왼쪽에서 왔을 때와 비교
			for(int y = 1; y < M; y++) {
				left[y] = Integer.max(left[y], left[y-1] + map[x][y]);
			}
			
			//오른쪽에서 왔을 때와 비교
			for(int y = M - 2; y >= 0; y--) {
				right[y] = Integer.max(right[y], right[y+1] + map[x][y]);
			}
			
			for(int y = 0; y < M; y++) {
				dp[x][y] = Integer.max(left[y], right[y]);
			}
			
		}
	}

}
