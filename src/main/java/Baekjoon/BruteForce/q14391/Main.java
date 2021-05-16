package Baekjoon.BruteForce.q14391;

import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] paper;
	
	public static void main(String[] args) {
		init();
		System.out.println(findMax());
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		paper = new int[N][M];
		for(int x = 0; x < N; x++) {
			String tmp = input.next();
			for(int y = 0; y < M; y++) {
				paper[x][y] = tmp.charAt(y) - '0';
			}
		}
		input.close();
	}
	
	// 0 : ��, 1 : |
	private static int findMax() {
		int result = 0;
		for(int s = 0; s < (1 << (N * M)); s++) {
			int sum1 = calcHorizontal(s);
			int sum2 = calcVertical(s);
			result = Integer.max(result, sum1 + sum2);
		}
		return result;
	}
	
	private static int calcHorizontal(int s) {
		int total = 0;
//		System.out.println("s->" + s);
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < M; j++) {
				int k = i * M + j;
				if((s & (1 << k)) == 0) { 
					sum = sum * 10 + paper[i][j];
				}
				else {
					total += sum;
					sum = 0;
				}
//				System.out.println("k->" + k);
//				System.out.println("(s&(1<<k))->" + (s&(1<<k)));
			}
			total += sum;
		}
//		System.out.println();
		return total;
	}
	
	private static int calcVertical(int s) {
		int total = 0;
		for(int i = 0; i < M; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				int k = j*M + i;
				if((s & (1 << k)) != 0 ) {
					sum = sum * 10 + paper[j][i];
				}
				else {
					total += sum;
					sum = 0;
				}
			}
			total += sum;
		}
		return total;
	}

}
