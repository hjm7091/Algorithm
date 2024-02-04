package baekjoon.simulation.q20058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	int N, Q, S;
	int A[][], copy[][], L[];
	int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.solve();
	}
	
	private void solve() throws IOException {
		init();
		castFireStorm();
		printResult();
	}

	private void printResult() {
		int sum = 0;
		int maxArea = 0;
		
		for(int i = 0; i < S; i++) {
			for(int j = 0; j < S; j++) {
				if(copy[i][j] != 0) {
					sum += copy[i][j];
				}
			}
		}
		
		for(int i = 0; i < S; i++) {
			for(int j = 0; j < S; j++) {
				if(copy[i][j] != 0) {
					maxArea = Math.max(maxArea, dfs(i, j, 1));
				}
			}
		}
		
		System.out.println(sum);
		System.out.println(maxArea);
	}
	
	private int dfs(int x, int y, int depth) {
		copy[x][y] = 0;
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(!rangeOver(nx, ny) && copy[nx][ny] != 0) {
				depth = dfs(nx, ny, depth + 1);
			}
		}
		
		return depth;
	}

	private void castFireStorm() {
		
//		System.out.println();
//		print(A, "before rotate");
		
		for(int l : L) {
			
//			System.out.println("l:" + l);
			
			int s = (int) Math.pow(2, l);
			
			for(int x = 0; x < S; x += s) {
				for(int y = 0; y < S; y += s) {
					rotate(x, y, s);
				}
			}
			
//			print(A, "after rotate");
			
			for(int x = 0; x < S; x++) {
				for(int y = 0; y < S; y++) {
					if(A[x][y] != 0) {
						int cnt = 0;
						for(int dir = 0; dir < 4; dir++) {
							int nx = x + dx[dir], ny = y + dy[dir];
							if(rangeOver(nx, ny) || A[nx][ny] == 0)
								continue;
							cnt++;
						}
						
						if(cnt < 3)
							copy[x][y] = A[x][y] - 1;
						else
							copy[x][y] = A[x][y];
					} else {
						copy[x][y] = 0;
					}
				}
			}
			
//			print(copy, "after reduce");
		}
	}

	private void print(int[][] arr, String message) {
		System.out.println("message : " + message);
		for(int i = 0; i < S; i++) {
			for(int j = 0; j < S; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void rotate(int startX, int startY, int size) {
		
		int endX = startX + size;
		int endY = startY + size;
		
		for(int r = startX, y = endY - 1; r < endX; r++, y--) {
			for(int c = startY, x = startX; c < endY; c++, x++) {
				A[x][y] = copy[r][c];
			}
		}

	}
	
	private boolean rangeOver(int x, int y) {
		return x < 0 || x > S - 1 || y < 0 || y > S - 1;
	}

	private void init() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] split = input.readLine().split(" ");
		N = Integer.parseInt(split[0]); Q = Integer.parseInt(split[1]);
		S = (int) Math.pow(2, N);
		A = new int[S][S];
		copy = new int[S][S];
		L = new int[Q];
		
		for(int i = 0; i < S; i++) {
			split = input.readLine().split(" ");
			for(int j = 0; j < split.length; j++) {
				A[i][j] = Integer.parseInt(split[j]);
				copy[i][j] = A[i][j];
			}
		}
		
		split = input.readLine().split(" ");
		for(int i = 0; i < split.length; i++) {
			L[i] = Integer.parseInt(split[i]);
		}
		
		input.close();
	}
	

}
