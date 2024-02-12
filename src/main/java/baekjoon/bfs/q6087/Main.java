package baekjoon.bfs.q6087;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x,y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int W,H;
	static char[][] map;
	static int[][] d;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Pair start, end;
	
	public static void main(String[] args) {
		init();
		bfs();
		System.out.println(d[end.x][end.y] - 1);
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		W = input.nextInt();
		H = input.nextInt();
		map = new char[H][W];
		d = new int[H][W];
		int k = 0;
		for(int i=0; i<H; i++) {
			map[i] = input.next().toCharArray();
			for(int j=0; j<W; j++) {
				if(map[i][j]=='C') {
					if(k == 0)
						start = new Pair(i, j);
					else
						end = new Pair(i, j);
					k++;
				}
				d[i][j] = -1;
			}
		}
		input.close();
	}
	
	private static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
        q.add(start);
        d[start.x][start.y] = 0;
        while(!q.isEmpty()) {
        	Pair now = q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                while (!rangeOver(nx, ny)) {
                    if (map[nx][ny] == '*') 
                    	break;
                    if (d[nx][ny] == -1) {
                        d[nx][ny] = d[now.x][now.y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }
        }
	}
	
	private static boolean rangeOver(int x, int y) {
		if(x < 0 || x > H-1 || y < 0 || y > W-1)
			return true;
		return false;
	}

}
