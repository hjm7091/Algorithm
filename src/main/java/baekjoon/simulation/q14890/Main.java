package baekjoon.simulation.q14890;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, L;
	static int[][] map;
	static boolean[] check;
	
	public static void main(String[] args) {
		init();
		System.out.println(countPossibleLine());
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		L = input.nextInt();
		map = new int[N][N];
		check = new boolean[N];
		for(int x = 0; x < N; x++)
			for(int y = 0; y < N; y++)
				map[x][y] = input.nextInt();
		input.close();
	}
	
	private static int countPossibleLine() {
		int result = 0;
		
		for(int x = 0; x < N; x++) {
			if(isPossibleLine(map[x], L))
				result++;
		}
		
		for(int y = 0; y < N; y++) {
			int[] tmp = new int[N];
			for(int x = 0; x < N; x++)
				tmp[x] = map[x][y];
			if(isPossibleLine(tmp, L))
				result++;
		}
		
		return result;
	}
	
	private static boolean isPossibleLine(int[] a, int l) {
		Arrays.fill(check, false);
		
		for(int i = 1; i < N; i++) {
			if(a[i-1] != a[i]) {
				
				int diff = Math.abs(a[i] - a[i-1]);
				
				if(diff != 1)
					return false;
				
				if(a[i-1] < a[i]) {
					
					for(int j = 1; j <= l; j++) {
						if(i-j < 0) // 경사로를 놓다가 범위를 벗어나는 경우
							return false;
						
						if(a[i-1] != a[i-j]) // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
							return false;
						
						if(check[i-j]) // 경사로를 놓은 곳에 또 경사로를 놓는 경우
							return false;
						
						check[i-j] = true;
					}
					
				} else {
					
					for(int j = 0; j < l; j++) {
						if(i+j >= N) // 경사로를 놓다가 범위를 벗어나는 경우
							return false;
						
						if(a[i] != a[i+j]) // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
							return false;
						
						if(check[i+j]) // 경사로를 놓은 곳에 또 경사로를 놓는 경우
							return false;
						
						check[i+j] = true;
					}
				}
			}
		}
		
		return true;
	}

}
