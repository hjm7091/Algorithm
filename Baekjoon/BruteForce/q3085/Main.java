package q3085;

import java.util.Scanner;

public class Main {
	
	static int N;
	static char[][] board;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int result;
	
	public static void main(String[] args) {
		init();
		considerAllCase();
		System.out.println(result);
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		board = new char[N][N];
		for(int i = 0; i < N; i++) 
			board[i] = input.next().toCharArray();
		input.close();
	}
	
	private static void considerAllCase() {
		result = Integer.max(result, countMax());
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				for(int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if(rangeOver(nx, ny))
						continue;
					swap(x, y, nx, ny);
					result = Integer.max(result, countMax());
					swap(x, y, nx, ny);
				}
			}
		}
	}
	
	private static boolean rangeOver(int x, int y) {
		if(x < 0 || x > N-1 || y < 0 || y > N-1)
			return true;
		return false;
	}
	
	private static void swap(int x, int y, int nx, int ny) {
		char tmp = board[x][y];
		board[x][y] = board[nx][ny];
		board[nx][ny] = tmp;
	}
	
	private static int countMax() {
		int max = 0;
		
		for(int x = 0; x < N; x++) {
			int num = 1;
			char prev = board[x][0];
			for(int y = 1; y < N; y++) {
				char now = board[x][y];
				if(now == prev) {
					num++;
				} else {
					max = Integer.max(num, max);
					num = 1;
					prev = now;
				}
			}
			max = Integer.max(num, max);
		}
		
		for(int y = 0; y < N; y++) {
			int num = 1;
			char prev = board[0][y];
			for(int x = 1; x < N; x++) {
				char now = board[x][y];
				if(now == prev) {
					num++;
				} else {
					max = Integer.max(num, max);
					num = 1;
					prev = now;
				}
			}
			max = Integer.max(num, max);
		}
		
		return max;
	}
}
