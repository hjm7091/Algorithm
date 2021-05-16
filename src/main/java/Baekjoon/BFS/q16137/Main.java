package Baekjoon.BFS.q16137;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x, y;
	int path; //0이면 오작교 쓴적 없음, 1이면 오작교 쓴적 있음
	int state; //현재 위치의 상태
	public Point(int x, int y, int path, int state) {
		this.x = x;
		this.y = y;
		this.path = path;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "x:" + x + " y:" + y + " state:" + state;
	}
}

public class Main {

	static int N, M;
	static int[][] land;
	static int[][][] move; //move[x][y][0] : 오작교를 안쓰고 가는 길, move[x][y][1] : 오작교를 쓰고 가는 길
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static final int CLIFF = 0;
	static final int NORMAL = 1;
	static final int BRIDGE = 2;
	
	public static void main(String[] args) {
		init();
		performBfs();
		System.out.println(Integer.min(move[N-1][N-1][0], move[N-1][N-1][1]));
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		land = new int[N][N];
		move = new int[N][N][2];
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				land[x][y] = input.nextInt();
				for(int z = 0; z < 2; z++)
					move[x][y][z] = Integer.MAX_VALUE;
			}
		}
		input.close();
	}
	
	private static void performBfs() {
		Queue<Point> q = new LinkedList<Point>();
		move[0][0][0] = 0;
		move[0][0][1] = 0;
		q.add(new Point(0, 0, 0, NORMAL));
//		print_notUseBridgePath();
//		print_useBridgePath();
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int dir = 0; dir < 4; dir++) {
				checkNext(now, dir, q);
			}
//			System.out.println(now.toString());
//			print_notUseBridgePath();
//			print_useBridgePath();
		}
//		print_notUseBridgePath();
//		print_useBridgePath();
	}
	
	private static void checkNext(Point now, int dir, Queue<Point> q) {
		int x = now.x;
		int y = now.y;
		int path = now.path;
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(checkRangeOver(nx, ny))
			return;
		int next = land[nx][ny];
		if(now.state == NORMAL && next == NORMAL) { //현재 : 일반 땅, 다음 : 일반 땅
			if(move[x][y][path] + 1 < move[nx][ny][path]) {
				move[nx][ny][path] = move[x][y][path] + 1;
				q.add(new Point(nx, ny, path, NORMAL));
			}
		}
		else if(now.state == NORMAL && next == CLIFF) { //현재 : 일반 땅, 다음 : 절벽
			if(path == 1 || isCrossed(nx, ny))
				return;
			if(move[x][y][path] < M) {
				if(M < move[nx][ny][path + 1]) {
					move[nx][ny][path + 1] = M;
					q.add(new Point(nx, ny, path + 1, CLIFF));
				}
			}
			else {
				int inc = increase(M, move[x][y][path]);
				if(inc < move[nx][ny][path + 1]) {
					move[nx][ny][path + 1] = inc;
					q.add(new Point(nx, ny, path + 1, CLIFF));
				}
			}
		}
		else if(now.state == NORMAL && (next != NORMAL && next != CLIFF)) { //현재 : 일반 땅, 다음 : 오작교
			int bridgeValue = land[nx][ny];
			if(move[x][y][path] < bridgeValue) {
				if(bridgeValue < move[nx][ny][path]) {
					move[nx][ny][path] = bridgeValue;
					q.add(new Point(nx, ny, path, BRIDGE));
				}
			}
			else {
				int inc = increase(bridgeValue, move[x][y][path]);
				if(inc < move[nx][ny][path]) {
					move[nx][ny][path] = inc;
					q.add(new Point(nx, ny, path, BRIDGE));
				}
			}
		}
		else if(now.state == CLIFF && next == NORMAL) { //현재 : 절벽, 다음 : 일반 땅
			if(move[x][y][path] + 1 < move[nx][ny][path]) {
				move[nx][ny][path] = move[x][y][path] + 1;
				q.add(new Point(nx, ny, path, NORMAL));
			}
		}
		else if(now.state == CLIFF && next == CLIFF) { //현재 : 절벽, 다음 : 절벽
			return;
		}
		else if(now.state == CLIFF && (next != NORMAL && next != CLIFF)) { //현재 : 절벽, 다음 : 오작교
			return;
		}
		else if(now.state == BRIDGE && next == NORMAL) { //현재 : 오작교, 다음 : 일반 땅
			if(move[x][y][path] + 1 < move[nx][ny][path]) {
				move[nx][ny][path] = move[x][y][path] + 1;
				q.add(new Point(nx, ny, path, NORMAL));
			}
		}
		else if(now.state == BRIDGE && next == CLIFF) { //현재 : 오작교, 다음 : 절벽
			return;
		}
		else if(now.state == BRIDGE && (next != NORMAL && next != CLIFF)) { //현재 : 오작교, 다음 : 오작교
			return;
		}
	}

	public static boolean isCrossed(int x, int y) {
		for(int dir = 0; dir < 4; dir++) {
			int nx1 = x + dx[dir];
			int ny1 = y + dy[dir];
			int nx2 = x + dx[(dir + 1) % 4];
			int ny2 = y + dy[(dir + 1) % 4];
			if(checkRangeOver(nx1, ny1) || checkRangeOver(nx2, ny2))
				continue;
			if(land[nx1][ny1] == 0 && land[nx2][ny2] == 0)
				return true;
		}
		return false;
	}
	
	private static int increase(int unit, int target) {
		int start = unit;
		while(start <= target) {
			start += unit;
		}
		return start;
	}
	
	private static boolean checkRangeOver(int x, int y) {
		if(x < 0 || x > N-1 || y < 0 || y > N-1)
			return true;
		return false;
	}
	
	private static void print_notUseBridgePath() {
		System.out.println("notUse");
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if(move[x][y][0] == Integer.MAX_VALUE)
					System.out.print("? ");
				else
					System.out.print(move[x][y][0] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void print_useBridgePath() {
		System.out.println("Use");
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if(move[x][y][1] == Integer.MAX_VALUE)
					System.out.print("? ");
				else
					System.out.print(move[x][y][1] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
