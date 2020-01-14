package q3197;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int R, C;
	static char[][] map;
	static Pair[] swan;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		R = input.nextInt();
		C = input.nextInt();
		map = new char[R][C];
		swan = new Pair[2];
		int idx = 0;
		for(int x=0; x<R; x++) {
			map[x] = input.next().toCharArray();
			for(int y=0; y<C; y++) {
				if(map[x][y]=='L') {
					swan[idx] = new Pair(x, y);
					idx++;
				}
			}
		}
		
		int[][] melt = getMeltingDay();
//		print(melt);
		int left = 0, right = 0, min = Integer.MAX_VALUE;
		for(int x=0; x<R; x++) 
			for(int y=0; y<C; y++) 
				right = melt[x][y] > right ? melt[x][y] : right; 
//		System.out.println(left + " " + right);
		
		while(left<=right) {
			int mid = (left + right) / 2;
			if(checkMeet(melt, mid)) {
				min = min > mid ? mid : min;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(min);
		input.close();
	}
	
	public static boolean checkMeet(int[][] melt, int limit) {
		boolean[][] visit = new boolean[R][C];
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(swan[0]);
		visit[swan[0].x][swan[0].y] = true;
		
		while(!q.isEmpty()) {
			Pair now = q.remove();
			for(int dir=0; dir<4; dir++) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				if(checkRangeOver(nx, ny) || visit[nx][ny])
					continue;
				if(melt[nx][ny]<=limit) {
					if((nx==swan[1].x) && (ny==swan[1].y))
						return true;
					visit[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}
			}
		}
		return false;
	}
	
	public static void print(int[][] map) {
		for(int x=0; x<R; x++)
			System.out.println(Arrays.toString(map[x]));
		System.out.println();
	}
	
	public static int[][] getMeltingDay() {
		Queue<Pair> q = new LinkedList<Pair>();
		for(int x=0; x<R; x++)
			for(int y=0; y<C; y++)
				if(map[x][y]!='X')
					q.add(new Pair(x, y));
		
		int[][] day = new int[R][C];
		while(!q.isEmpty()) {
			Pair now = q.remove();
			int nowDay = day[now.x][now.y];
			for(int dir=0; dir<4; dir++) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				if(checkRangeOver(nx, ny))
					continue;
				if(map[nx][ny]=='X') {
					if(day[nx][ny]==0) {
						day[nx][ny] = nowDay+1;
						q.add(new Pair(nx, ny));
					}
					else {
						if(nowDay+1 < day[nx][ny]) {
							day[nx][ny] = nowDay+1;
							q.add(new Pair(nx, ny));
						}
					}
				}
				else {
					continue;
				}
			}
		}
		return day;
	}
	
	public static boolean checkRangeOver(int x, int y) {
		if(x<0 || x>R-1 || y<0 || y>C-1)
			return true;
		return false;
	}

}
