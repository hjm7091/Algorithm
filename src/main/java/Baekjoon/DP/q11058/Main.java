package Baekjoon.DP.q11058;

import java.util.Scanner;

public class Main {

	static long[] d; //D[i] = 크리보드의 버튼을 총 i번 눌러서 화면에 출력된 A개수의 최대값
	static int N;
	
	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		d = new long[101];
		d[1] = 1; d[2] = 2; d[3] = 3;
		for(int i=4; i<=N; i++) {
			d[i] = Long.max(d[i-1]+1, findmax(i));
		}
//		for(int i=1; i<=N; i++)
//			System.out.print(d[i]+" ");
//		System.out.println();
		System.out.println(d[N]);
		input.close();
	}
	
	public static long findmax(int n) {
		long result = Long.MIN_VALUE;
		int i = 3;
		int pow = 2;
		while(n-i>=1) {
			result = Long.max(result, d[n-i]*pow);
			i++;
			pow++;
		}
		return result;
	}

}
