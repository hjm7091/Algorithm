package baekjoon.brute_force.q4574;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static final int MAX_SIZE = 9;
	static final int MAX_NUM = 10;
	static int[][] puzzle;
	static boolean[][] row, col, rect;
	static boolean[][] domino;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		playGame();
	}
	
	private static void playGame() throws IOException{
		int gameNum = 1;
		while(true) {
			N = Integer.parseInt(input.readLine());
			if(N == 0)
				break;
			init();
			output.write("Puzzle " + gameNum + "\n");
			start(0);
			gameNum++;
		}
		output.flush();
		input.close();
		output.close();
	}
	
	private static void init() throws IOException{
		flag = false;
		puzzle = new int[MAX_SIZE][MAX_SIZE];
		row = new boolean[MAX_SIZE][MAX_NUM];
		col = new boolean[MAX_SIZE][MAX_NUM];
		rect = new boolean[MAX_SIZE][MAX_NUM];
		domino = new boolean[MAX_NUM][MAX_NUM];
		
		for(int i = 0; i < N; i++) {
			String[] info = input.readLine().split(" ");
			Point p = getPoint(info[1]);
			fillPuzzle(Integer.parseInt(info[0]), p.x, p.y);
			p = getPoint(info[3]);
			fillPuzzle(Integer.parseInt(info[2]), p.x, p.y);
			addDomino(info[0], info[2]);
		}
		
		String[] info = input.readLine().split(" ");
		for(int i = 0; i < info.length; i++) {
			Point p = getPoint(info[i]);
			fillPuzzle(i+1, p.x, p.y);
		}
	}
	
	private static Point getPoint(String coord) {
		int x = coord.charAt(0) - 'A';
		int y = (coord.charAt(1) - '0') - 1;
		return new Point(x, y);
	}
	
	private static void fillPuzzle(int value, int x, int y) {
		puzzle[x][y] = value;
		row[x][value] = true;
		col[y][value] = true;
		rect[getRectNum(x, y)][value] = true;
	}
	
	private static void emptyPuzzle(int value, int x, int y) {
		puzzle[x][y] = 0;
		row[x][value] = false;
		col[y][value] = false;
		rect[getRectNum(x, y)][value] = false;
	}
	
	private static int getRectNum(int x, int y) {
		return ((x / 3) * 3) + (y / 3);
	}
	
	private static void addDomino(String info1, String info2) {
		int v1 = Integer.parseInt(info1);
		int v2 = Integer.parseInt(info2);
		domino[v1][v2] = true;
		domino[v2][v1] = true;
	}
	
	private static void start(int now) throws IOException {
		if(flag)
			return;
		if(now == 81) {
			flag = true;
			printPuzzle();
			return;
		}
		Point p = new Point(now / MAX_SIZE, now % MAX_SIZE);
		if(puzzle[p.x][p.y] != 0) {
			start(now + 1);
		} else {
			for(int i = 1; i < MAX_NUM - 1; i++) {
				for(int j = i+1; j < MAX_NUM; j++) {
					if(domino[i][j] == false) {
						domino[i][j] = true;
						for(int dir = 0; dir < 2; dir++) {
							Point np = new Point(p.x + dx[dir], p.y + dy[dir]);
							if(canPut(np.x, np.y)) { //배치 가능하고
								if(!breakRule(p, i) && !breakRule(np, j)) { //스도쿠 룰을 어기지 않는다면
									putDomino(p, np, i, j);
									start(now + 1);
									removeDomino(p, np, i, j);
								}
								
								if(!breakRule(p, j) && !breakRule(np, i)) { //스도쿠 룰을 어기지 않는다면
									putDomino(p, np, j, i);
									start(now + 1);
									removeDomino(p, np, j, i);
								}
							}
						}
						domino[i][j] = false;
					}
				}
			}
		}
	}
	
	private static boolean canPut(int x, int y) {
		if(x < 0 || x > MAX_SIZE - 1 || y < 0 || y > MAX_SIZE - 1)
			return false;
		if(puzzle[x][y] != 0)
			return false;
		return true;
	}
	
	private static void putDomino(Point p1, Point p2, int v1, int v2) {
		fillPuzzle(v1, p1.x, p1.y);
		fillPuzzle(v2, p2.x, p2.y);
	}
	
	private static void removeDomino(Point p1, Point p2, int v1, int v2) {
		emptyPuzzle(v1, p1.x, p1.y);
		emptyPuzzle(v2, p2.x, p2.y);
	}
	
	private static boolean breakRule(Point p, int value) {
		if(row[p.x][value] || col[p.y][value] || rect[getRectNum(p.x, p.y)][value])
			return true;
		return false;
	}
	
	private static void printPuzzle() throws IOException {
		for(int x = 0; x < MAX_SIZE; x++) {
			StringBuilder sb = new StringBuilder();
			for(int y = 0; y < MAX_SIZE; y++) {
				sb.append(puzzle[x][y]);
			}
			output.write(sb.toString() + "\n");
		}
	}

}
