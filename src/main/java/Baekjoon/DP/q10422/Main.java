package Baekjoon.DP.q10422;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int T;
	static long[] d = new long[5001];
	static final long mod = 1000000007L;
	
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = input.nextInt();
		Arrays.fill(d, -1);
		while(T-- > 0) {
			int L = input.nextInt();
			if(L % 2 == 0)
				output.write(go(L)+"\n");
			else
				output.write("0\n");
		}
		output.flush();
		output.close();
		input.close();
	}
	
	private static long go(int n) {
		if(n == 0)
			return 1;
		if(d[n] != -1)
			return d[n];
		d[n] = 0;
		for(int i = 2; i <= n; i+=2) {
			d[n] += go(i-2) * go(n-i);
			d[n] %= mod;
		}
		return d[n];
	}

}
