package baekjoon.brute_force.q1208;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M, S;
	static int[] first, second, A;
	
	public static void main(String[] args) {
		init();
		divide();
		System.out.println(findAnswer());
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
        N = input.nextInt();
        S = input.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = input.nextInt();
        }
        input.close();
	}
	
	private static void divide() {
		M = N / 2;
        N = N - M;
        first = new int[1 << N];
        for (int i = 0; i < (1 << N); i++) {
            for (int k = 0; k < N; k++) {
                if ((i & (1 << k)) == (1 << k)) {
                    first[i] += A[k];
                }
            }
        }
        second = new int[1 << M];
        for (int i = 0; i < (1 << M); i++) {
            for (int k = 0; k < M; k++) {
                if ((i & (1 << k)) == (1 << k)) {
                    second[i] += A[k + N];
                }
            }
        }
        Arrays.sort(first);
        Arrays.sort(second);
	}
	
	private static long findAnswer() {
		N = 1 << N;
		M = 1 << M;
		int i = 0, j = M - 1;
		long result = 0;
		while(i < N && j >= 0) {
			if(first[i] + second[j] == S) {
				i++;
				long cnt1 = 1;
				while(i < N && first[i] == first[i-1]) {
					cnt1++;
					i++;
				}
				j--;
				long cnt2 = 1;
				while(j >= 0 && second[j] == second[j+1]) {
					cnt2++;
					j--;
				}
				result += cnt1 * cnt2;
			}
			else if(first[i] + second[j] < S)
				i++;
			else
				j--;
		}
		if(S == 0) result--;
		return result;
	}

}
