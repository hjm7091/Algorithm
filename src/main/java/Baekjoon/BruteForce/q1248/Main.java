package Baekjoon.BruteForce.q1248;

import java.util.Scanner;

public class Main {

	static int N;
	static int[] A;
	static int[][] sign;
	
	public static void main(String[] args) {
		init();
		considerAllCase(0);
		for(int i = 0; i < N; i++) {
			System.out.print(A[i] + " ");
		}
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		A = new int[N];
		sign = new int[N][N];
		String S = input.next();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				char c = S.charAt(cnt);
				if(c == '0')
					sign[i][j] = 0;
				else if(c == '+')
					sign[i][j] = 1;
				else if(c == '-')
					sign[i][j] = -1;
				cnt++;
			}
		}
		input.close();
	}
	
	private static boolean considerAllCase(int index) {
		if(index == N) {
			return true;
		}
		if(sign[index][index] == 0) {
			A[index] = 0;
			return ok(index) && considerAllCase(index + 1);
		}
		for(int i = 1; i <= 10; i++) {
			A[index] = sign[index][index] * i;
			if(ok(index) && considerAllCase(index + 1))
				return true;
		}
		return false;
	}
	
	private static boolean ok(int index) {
		int sum = 0;
		for(int i = index; i >= 0; i--) {
			sum += A[i];
			if(sign[i][index] == 0) {
				if(sum != 0) return false;
			}
			else if(sign[i][index] == 1) {
				if(sum <= 0) return false;
			}
			else if(sign[i][index] == -1) {
				if(sum >= 0) return false;
			}
		}
		return true;
	}

}
