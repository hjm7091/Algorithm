package q2151;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x, y;
	int dir, cnt;
	public Point(int x, int y, int dir, int cnt) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.cnt = cnt;
	}
}

public class Main {

	static int N;
	static char[][] map;
	static int[][] record;
	static int startX, startY;
	static int endX, endY;
	static final int UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4;
	
	public static void main(String[] args) {
		input();
		performBfs();
		System.out.println(record[endX][endY]);
	}

	private static void input() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		map = new char[N][N];
		record = new int[N][N];
		boolean change = true;
		for(int x=0; x<N; x++) {
			map[x] = input.next().toCharArray();
			Arrays.fill(record[x], Integer.MAX_VALUE);
			for(int y=0; y<N; y++) {
				if(map[x][y]=='#') {
					if(change) {
						startX = x;
						startY = y;
						change = false;
					}
					else {
						endX = x;
						endY = y;
					}
				}
			}
		}
		input.close();
	}
	
	private static void performBfs() {
		Queue<Point> q = new LinkedList<>();
		determineFirstDir(q);
		while(!q.isEmpty()) {
			Point now = q.poll();
			switch (now.dir) {
				case UP: 
					checkUp(now, q, 0);
					checkLeft(now, q, 1);
					checkRight(now, q, 1);
					break;
				case RIGHT: 
					checkRight(now, q, 0);
					checkUp(now, q, 1);
					checkDown(now, q, 1);
					break;
				case DOWN:
					checkDown(now, q, 0);
					checkLeft(now, q, 1);
					checkRight(now, q, 1);
					break;
				case LEFT:
					checkLeft(now, q, 0);
					checkUp(now, q, 1);
					checkDown(now, q, 1);
					break;
			}
		}
	}
	
	private static void checkUp(Point now, Queue<Point> q, int plusCnt) {
		int nextCnt = now.cnt + plusCnt;
		int nextY = now.y;
		for(int nextX = now.x - 1; nextX >= 0; nextX--) {
			if(map[nextX][nextY] == '*')
				return;
			if(canMove(nextX, nextY, nextCnt)) {
				q.add(new Point(nextX, nextY, UP, nextCnt));
				record[nextX][nextY] = nextCnt;
			}
		}
	}
	
	private static void checkRight(Point now, Queue<Point> q, int plusCnt) {
		int nextCnt = now.cnt + plusCnt;
		int nextX = now.x;
		for(int nextY = now.y + 1; nextY < N; nextY++) {
			if(map[nextX][nextY] == '*')
				return;
			if(canMove(nextX, nextY, nextCnt)) {
				q.add(new Point(nextX, nextY, RIGHT, nextCnt));
				record[nextX][nextY] = nextCnt;
			}
		}
	}
	
	private static void checkDown(Point now, Queue<Point> q, int plusCnt) {
		int nextCnt = now.cnt + plusCnt;
		int nextY = now.y;
		for(int nextX = now.x + 1; nextX < N; nextX++) {
			if(map[nextX][nextY] == '*')
				return;
			if(canMove(nextX, nextY, nextCnt)) {
				q.add(new Point(nextX, nextY, DOWN, nextCnt));
				record[nextX][nextY] = nextCnt;
			}
		}
	}
	
	private static void checkLeft(Point now, Queue<Point> q, int plusCnt) {
		int nextCnt = now.cnt + plusCnt;
		int nextX = now.x;
		for(int nextY = now.y - 1; nextY >= 0; nextY--) {
			if(map[nextX][nextY] == '*')
				return;
			if(canMove(nextX, nextY, nextCnt)) {
				q.add(new Point(nextX, nextY, LEFT, nextCnt));
				record[nextX][nextY] = nextCnt;
			}
		}
	}
	
	private static boolean canMove(int x, int y, int cnt) {
		if(map[x][y] == '!' && cnt < record[x][y] 
				|| (x == endX && y == endY && map[x][y] == '#') && cnt < record[x][y])
			return true;
		return false;
	}
	
	private static void determineFirstDir(Queue<Point> q) {
		q.add(new Point(startX, startY, UP, 0));
		q.add(new Point(startX, startY, RIGHT, 0));
		q.add(new Point(startX, startY, DOWN, 0));
		q.add(new Point(startX, startY, LEFT, 0));
		record[startX][startY] = 0;
	}

}
