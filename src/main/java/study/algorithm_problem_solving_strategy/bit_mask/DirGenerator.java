package study.algorithm_problem_solving_strategy.bit_mask;

import java.util.Arrays;

public class DirGenerator {

	static final int LIMIT = 5;
	
	public static void main(String[] args) {
		for(int k = 0; k < (1 << (LIMIT * 2)); k++) {
			int[] dir = genDir(k);
			System.out.println(Arrays.toString(dir));
		}
	}
	
	private static int[] genDir(int k) {
		int[] dir = new int[LIMIT];
		for(int idx = 0; idx < LIMIT; idx++) {
			dir[idx] = k & 3;
			k = k >> 2;
		}
		return dir;
	}

}
