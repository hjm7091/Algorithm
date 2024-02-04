package baekjoon.simulation.q20055;

import java.util.Scanner;

public class Main {

	static int N, K;
	static int end;
	static Integer[] A;
	static Boolean[] robot;
	
	public static void main(String[] args) {
		init();
		
		int step = 0;
		
		while(canContinue()) {
			moveCell();
			moveRobot();
			putRobot();
			step++;
		}
		
		System.out.println(step);
	}
	
	private static void putRobot() {
		if(A[1] > 0 && robot[1] == false) {
			A[1]--;
			robot[1] = true;
		}
	}

	private static void moveRobot() {
		
		robot[N] = robot[N] ? false : robot[N];
		
		for(int i = N - 1; i >= 1; i--) {
			if(robot[i] && A[i + 1] > 0 && !robot[i + 1]) {
				robot[i] = false;
				robot[i + 1] = true;
				A[i + 1]--;
			}
		}
		
		robot[N] = robot[N] ? false : robot[N];
	}

	private static void moveCell() {
		Integer last = A[end];
		for(int i = end - 1; i >= 1; i--) {
			A[i + 1] = A[i];
			robot[i + 1] = robot[i];
		}
		A[1] = last;
		robot[1] = false;
	}

	private static boolean canContinue() {
		int count = 0;
		for(int i = 1; i <= end; i++) {
			if(A[i] == 0)
				count++;
			
			if(count >= K)
				return false;
		}
		return true;
	}

	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt(); K = input.nextInt();
		end = 2 * N;
		A = new Integer[end + 1]; robot = new Boolean[end + 1];
		for(int i = 1; i <= end; i++) {
			A[i] = input.nextInt();
			robot[i] = false;
		}
		input.close();
	}

}
