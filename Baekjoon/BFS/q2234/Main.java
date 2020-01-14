package q2234;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int maxSize = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		map = new int[m][n];
		visit = new boolean[m][n];
		for(int x=0; x<m; x++) 
			for(int y=0; y<n; y++) 
				map[x][y] = input.nextInt();
			
		int roomCnt = 0;
		for(int x=0; x<m; x++) {
			for(int y=0; y<n; y++) {
				if(!visit[x][y]) {
					bfs(x, y);
					roomCnt++;
				}
			}
		}
		
		System.out.println(roomCnt);
		System.out.println(maxSize);
		
		for(int x=0; x<m; x++) {
			for(int y=0; y<n; y++) {
				removeWall(x, y);
			}
		}
		
		System.out.println(maxSize);
		input.close();
	}
	
	public static void removeWall(int x, int y) {
		for(int i=0; i<4; i++) {
			if((map[x][y] & (1<<i))!=0) {
				for(int j=0; j<m; j++)
					Arrays.fill(visit[j], false);
				map[x][y] -= (1<<i);
				bfs(x, y);
				map[x][y] += (1<<i);
			}
		}
	}

	public static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));
		visit[x][y] = true;
		int roomSize = 0;
		while(!q.isEmpty()) {
			Pair now = q.remove();
			roomSize++;
			for(int i=0; i<4; i++) {
				if((map[now.x][now.y] & (1<<i))!=0)
					continue;
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				if(checkOver(nextX, nextY) || visit[nextX][nextY])
					continue;
				visit[nextX][nextY] = true;
				q.add(new Pair(nextX, nextY));
			}
		}
		maxSize = Integer.max(maxSize, roomSize);
	}
	
	public static boolean checkOver(int x, int y) {
		if(x<0 || x>m-1 || y<0 || y>n-1)
			return true;
		return false;
	}
}

class Pair {
	
	public int x, y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}