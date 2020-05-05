package q14503;

import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static int r, c, d;
	
	public static void main(String[] args) {
		init();
		System.out.println(go(r, c, d));
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		map = new int[N][M];
		r = input.nextInt();
		c = input.nextInt();
		d = input.nextInt();
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				map[x][y] = input.nextInt();
			}
		}
		input.close();
	}
	
	private static int go(int x, int y, int dir) {
		while(true) {
			if(map[x][y] == 0) {
				map[x][y] = 2;
			}
			if(map[x-1][y] != 0 && map[x][y+1] != 0 && map[x+1][y] != 0 && map[x][y-1] != 0) {
				if(map[x-dx[dir]][y-dy[dir]] == 1) {
					break;
				} else {
					x -= dx[dir];
					y -= dy[dir];
				}
			} else {
				dir = dir - 1 < 0 ? 3 : dir - 1;
				if(map[x+dx[dir]][y+dy[dir]] == 0) {
					x += dx[dir];
					y += dy[dir];
				}
			}
		}
		
		int result = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 2)
					result++;
			}
		}
		
		return result;
	}

}
