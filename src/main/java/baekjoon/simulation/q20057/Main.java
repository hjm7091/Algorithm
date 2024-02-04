package baekjoon.simulation.q20057;

import java.util.Scanner;

class Position {
	int x, y;
	int sand;

	public Position(int x, int y, int sand) {
		this.x = x;
		this.y = y;
		this.sand = sand;
	}
}

public class Main {
	
	int A[][], N;
	int[] dx = {0,1,0,-1}, dy = {-1,0,1,0};
	int out = 0;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solve();
	}

	private void solve() {
		init();
		castTornado();
		System.out.println(out);
	}

	private void castTornado() {
		int x = N / 2, y = N / 2;
		int dir = 0;
		int repeat = 1, now = 0, twice = 0;
		
		while(x != 0 || y != 0) {
			x += dx[dir];
			y += dy[dir];
			
			if(A[x][y] > 0)
				scatterSand(x, y, dir);
			
//			print(A, "after scatter.");
			
			now++;
			
			if(now == repeat) {
				dir = ++dir > 3 ? 0 : dir;
				now = 0;
				twice++;
			}
			
			if(twice == 2) {
				repeat++;
				twice = 0;
			}
		}

	}

	private void print(int[][] A, String message) {
		System.out.println(message);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void scatterSand(int x, int y, int dir) {
		int sand = A[x][y];
		A[x][y] = 0;
		
		int rDir = dir - 1 < 0 ? 3 : dir - 1;
		int lDir = dir + 1 > 3 ? 0 : dir + 1;
		int reverseDir = dir + 2 > 3 ? dir / 3 : dir + 2; 
		
		Position[] positions = {
			//현재와 같은 방향  + 2
			new Position(x + 2 * dx[dir], y + 2 * dy[dir], (int)(sand * (5.0 / 100))),
			
			//현재와 같은 방향  + 1, 오른쪽 + 1
			new Position(x + dx[dir] + dx[rDir], y + dy[dir] + dy[rDir], (int)(sand * (10.0 / 100))),
			
			//현재와 같은 방향  + 1, 왼쪽 + 1
			new Position(x + dx[dir] + dx[lDir], y + dy[dir] + dy[lDir], (int)(sand * (10.0 / 100))),
			
			//현재 방향의 오른쪽 + 1
			new Position(x + dx[rDir], y + dy[rDir], (int)(sand * (7.0 / 100))),
			
			//현재 방향의 왼쪽 + 1
			new Position(x + dx[lDir], y + dy[lDir], (int)(sand * (7.0 / 100))),
			
			//현재 방향의 오른쪽 + 2
			new Position(x + 2 * dx[rDir], y + 2 * dy[rDir], (int)(sand * (2.0 / 100))),
			
			//현재 방향의 왼쪽 + 2
			new Position(x + 2 * dx[lDir], y + 2 * dy[lDir], (int)(sand * (2.0 / 100))),
			
			//현재의 역방향 + 1, 오른쪽 + 1
			new Position(x + dx[reverseDir] + dx[rDir], y + dy[reverseDir] + dy[rDir], (int)(sand * (1.0 / 100))),
			
			//현재의 역방향 + 1, 왼쪽 + 1
			new Position(x + dx[reverseDir] + dx[lDir], y + dy[reverseDir] + dy[lDir], (int)(sand * (1.0 / 100)))	
		};
		
		for(Position position : positions) {
			sand -= position.sand;
			
			if(rangeOver(position.x, position.y))
				out += position.sand;
			else
				A[position.x][position.y] += position.sand;
		}
		
		Position alpha = new Position(x + dx[dir], y + dy[dir], sand);
		if(rangeOver(alpha.x, alpha.y)) 
			out += alpha.sand;
		else
			A[alpha.x][alpha.y] += alpha.sand;
	}

	private boolean rangeOver(int x, int y) {
		return x < 0 || x > N - 1 || y < 0 || y > N - 1;
	}

	private void init() {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		A = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				A[i][j] = input.nextInt();
			}
		}
		
		input.close();
	}

}
