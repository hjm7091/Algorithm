package Baekjoon.BruteForce.q10026;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static char[][] map;
	static int[][] board;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result1, result2;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		map = new char[N][N];
		board = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) 
			map[i] = input.next().toCharArray();
		
		int color = 0;
		for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				if(!visit[x][y]) {
					color++;
					dfs(x, y, color, false);
				}
			}
		}
		result1 = color;
		
		color = 0;
		for(int i=0; i<N; i++)
			Arrays.fill(visit[i], false);
		
		for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				if(!visit[x][y]) {
					color++;
					dfs(x, y, color, true);
				}
			}
		}
		result2 = color;
		
		System.out.println(result1 + " " + result2);
		input.close();
	}
	
	public static void dfs(int x, int y, int color, boolean blindness) {
		visit[x][y] = true;
		board[x][y] = color;
		char nowColor = map[x][y];
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(checkOver(nx, ny) || visit[nx][ny])
				continue;
			char nextColor = map[nx][ny];
			if(blindness) {
				if(nowColor==nextColor)
					dfs(nx, ny, color, blindness);
				else {
					if((nowColor=='R' || nowColor=='G') && (nextColor=='R' || nextColor=='G')) 
						dfs(nx, ny, color, blindness);
				}
			}
			else {
				if(nowColor==nextColor)
					dfs(nx, ny, color, blindness);
			}
		}
	}
	
	public static boolean checkOver(int x, int y) {
		if(x<0 || x>N-1 || y<0 || y>N-1)
			return true;
		return false;
	}

}
