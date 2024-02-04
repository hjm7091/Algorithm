package baekjoon.brute_force.q1806;

import java.util.Scanner;

public class Main {

	static int N, S;
	static int[] A;
	
	public static void main(String[] args) {
		init();
		System.out.println(go());
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		S = input.nextInt();
		A = new int[N+1];
		for(int i = 0; i < N; i++) 
			A[i] = input.nextInt();
		input.close();
	}
	
	private static int go() {
		int result = N + 1;
		int left = 0, right = 0;
		int sum = A[0];
		while(left <= right && right < N) {
			if(sum < S) {
				right++;
				sum += A[right];
			}
			else if(sum == S) {
				result = Integer.min(result, right - left + 1);
				right++;
				sum += A[right];
			}
			else if(sum > S) {
				result = Integer.min(result, right - left + 1);
				sum -= A[left];
				left++;
			}
		}
		if(result > N)
			result = 0;
		return result;
	}

}
