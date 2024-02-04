package baekjoon.brute_force.q1339;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static int N;
	static String[] words;
	static Set<Character> letterSet = new HashSet<>();
	static Character[] letters;
	static int[] values;
	static boolean[] visit = new boolean[10];
	static int[] alpha = new int[256];
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		input();
		makePermutation(0);
		System.out.println(result);
	}
	
	private static void input() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		words = new String[N];
		for(int i = 0; i < N; i++) {
			words[i] = input.next();
			for(char c : words[i].toCharArray()) {
				letterSet.add(c);
			}
		}
		letters = letterSet.toArray(new Character[letterSet.size()]);
		values = new int[letterSet.size()];
		input.close();
	}
	
	private static void makePermutation(int index) {
		if(index == values.length) {
			result = Integer.max(result, calc());
			return;
		}
		for(int i = 0; i < 10; i++) {
			if(!visit[i]) {
				visit[i] = true;
				values[index] = i;
				makePermutation(index+1);
				visit[i] = false;
			}
		}
	}
	
	private static int calc() {
		int sum = 0;
		Arrays.fill(alpha, 0);
		for(int i = 0; i < values.length; i++) {
			alpha[letters[i]] = values[i];
		}
		for(String word : words) {
			int now = 0;
			for(char c : word.toCharArray()) {
				now = now * 10 + alpha[c];
			}
			sum += now;
		}
		return sum;
	}

}
