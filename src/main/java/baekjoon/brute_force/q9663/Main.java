package baekjoon.brute_force.q9663;

import java.util.Scanner;

public class Main {

	static int N;
	static boolean[] checkY = new boolean[15];
	static boolean[] checkLeftDiag = new boolean[30];
	static boolean[] checkRightDiag = new boolean[30];
	
	public static void main(String[] args) {
		init();
		System.out.println(findHow(0));
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		input.close();
	}
	
	private static int findHow(int x) {
		if(x == N) 
			return 1;
		int cnt = 0;
		for(int y = 0; y < N; y++) {
			if(canPut(x, y)) {
				put(x, y);
				cnt += findHow(x+1);
				notPut(x, y);
			}
		}
		return cnt;
	}
	
	private static boolean canPut(int x, int y) {
		if(checkY[y])
			return false;
		if(checkLeftDiag[x+y])
			return false;
		if(checkRightDiag[x-y+N-1])
			return false;
		return true;
	}
	
	private static void put(int x, int y) {
		checkY[y] = true;
		checkLeftDiag[x+y] = true;
		checkRightDiag[x-y+N-1] = true;
	}
	
	private static void notPut(int x, int y) {
		checkY[y] = false;
		checkLeftDiag[x+y] = false;
		checkRightDiag[x-y+N-1] = false;
	}

}
