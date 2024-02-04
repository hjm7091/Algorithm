package baekjoon.brute_force.q1987;

import java.util.Scanner;

public class Main {

	static int R, C;
	static char[][] board;
	static boolean[] check = new boolean[26];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		init();
		System.out.println(go(0, 0, 1));
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		R = input.nextInt();
		C = input.nextInt();
		board = new char[R][C];
		for(int x = 0; x < R; x++)
			board[x] = input.next().toCharArray();
		check[board[0][0] - 'A'] = true;
		input.close();
	}
	
	private static int go(int x, int y, int cnt) {
		int result = cnt;
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(!rangeOver(nx, ny)) {
				if(!check[board[nx][ny] - 'A']) {
					check[board[nx][ny] - 'A'] = true;
					result = Integer.max(result, go(nx, ny, cnt+1));
					check[board[nx][ny] - 'A'] = false;
				}
			}
		}
		return result;
	}
	
	private static boolean rangeOver(int x, int y) {
		if(x <0 || x > R-1 || y < 0 || y > C-1)
			return true;
		return false;
	}

}
