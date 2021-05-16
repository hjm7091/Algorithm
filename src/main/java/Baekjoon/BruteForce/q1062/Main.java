package Baekjoon.BruteForce.q1062;

import java.util.Scanner;

public class Main {

	static int N, K;
	static int[] words; //words[i] = i��° �ܾ ���Ե� ���ĺ��� ��Ʈ����ũ
	
	public static void main(String[] args) {
		init();
		System.out.println(go(0, K, 0));
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		words = new int[N];
		for(int i = 0; i < N; i++) {
			char[] word = input.next().toCharArray();
			for(char c : word) {
				words[i] = words[i] | (1 << (c-'a'));
			}
		}
		input.close();
	}
	
	private static int go(int index, int k, int mask) {
		if(k < 0)
			return 0;
		if(index == 26) {
			return count(mask);
		}
		int result = 0;
		result = Integer.max(result, go(index+1, k-1, mask | (1 << (index))));
		if(canGo(index)) {
			result = Integer.max(result, go(index+1, k, mask));
		}
		return result;
	}
	
	private static boolean canGo(int i) {
		if((i != 'a'-'a') && (i != 'n'-'a') && (i != 't'-'a')
				&& (i != 'i'-'a') && (i != 'c'-'a'))
			return true;
		return false;
	}
	
	private static int count(int mask) { //mask : ��� ���ĺ��� ��Ʈ����ũ ��
		int cnt = 0;
		for(int word : words) {
			if((word & ((1 << 26) - 1 - mask)) == 0) { //(1 << 26) - 1 - mask : mask�� ����
				cnt++;
			}
		}
		return cnt;
	}

}
