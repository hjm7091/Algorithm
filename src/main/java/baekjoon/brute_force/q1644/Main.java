package baekjoon.brute_force.q1644;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static boolean[] c;
	static List<Integer> prime = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		init();
		System.out.println(go());
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		c = new boolean[N+1];
		for(int i = 2; i <= N; i++) {
			if(!c[i]) {
				prime.add(i);
				for(int j = i * 2; j <= N; j+=i) {
					c[j] = true;
				}
			}
		}
		input.close();
	}
	
	private static int go() {
		int result = 0;
		int left = 0, right = 0;
		int sum = prime.size() > 0 ? prime.get(0) : 0;
		while(left <= right && right < prime.size()) {
			if(sum <= N) {
				if(sum == N) {
					result++;
				}
				right++;
				if(right < prime.size()) {
					sum += prime.get(right);
				}
			}
			else {
				sum -= prime.get(left++);
			}
		}
		return result;
	}

}
