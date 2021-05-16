package Baekjoon.BruteForce.q1107;

import java.util.Scanner;

public class Main {

	static int N, M;
	static boolean[] broken = new boolean[10];
	static int result;
	
	public static void main(String[] args) {
		input();
		findMinimumCase();
		System.out.println(result);
	}
	
	private static void input() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		for(int i = 0; i < M; i++) {
			int button = input.nextInt();
			broken[button] = true;
		}
		result = Math.abs(N - 100);
		input.close();
	}
	
	private static void findMinimumCase() {
		for(int c = 0; c <= 1000000; c++) {
			int targetChannel = c;
			int counting = countNumber(targetChannel);
			if(counting > 0) {
				int press = Math.abs(targetChannel - N);
				result = Integer.min(result, counting + press); 
			}
		}
	}
	
	private static int countNumber(int ch) {
		if(ch == 0) {
			if(broken[ch])
				return 0;
			else
				return 1;
		}
		
		int count = 0;
		while(ch > 0) {
			if(broken[ch % 10])
				return 0;
			count++;
			ch /= 10;
		}
		
		return count;
	}

}
