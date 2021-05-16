package Baekjoon.DP.q2169;

import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] dp; //(x, y)���� ���µ� Ž���� �������� ��ġ�� �ִ밪
	static int[] left; //���ʰ� ���ʿ��� ���� ���� ��
	static int[] right; //���ʰ� �����ʿ��� ���� ���� ��
	
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
		
		//ù��° �� ó��
		dp[0][0] = map[0][0];
		for(int x = 0, y = 1; y < M; y++) {
			dp[x][y] = dp[x][y-1] + map[x][y];
		}
		
		for(int x = 1; x < N; x++) {
			
			//���ʿ��� �������� ���� left, right�� ���� ����
			for(int y = 0; y < M; y++) {
				left[y] = right[y] = dp[x-1][y] + map[x][y];
			}
			
			//���ʿ��� ���� ���� ��
			for(int y = 1; y < M; y++) {
				left[y] = Integer.max(left[y], left[y-1] + map[x][y]);
			}
			
			//�����ʿ��� ���� ���� ��
			for(int y = M - 2; y >= 0; y--) {
				right[y] = Integer.max(right[y], right[y+1] + map[x][y]);
			}
			
			for(int y = 0; y < M; y++) {
				dp[x][y] = Integer.max(left[y], right[y]);
			}
			
		}
	}

}
