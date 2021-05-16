package Baekjoon.DP.q11066;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int T,K;
	static int[] size;
	static int[][] d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(input.readLine());
		while(T-->0) {
			K = Integer.parseInt(input.readLine());
			size = new int[K+1];
			d = new int[K+1][K+1];
			StringTokenizer st = new StringTokenizer(input.readLine());
			for(int i=1; i<=K; i++) 
				size[i] = Integer.parseInt(st.nextToken());
	
//			bottom-up ���
//			int range = 1;
//			while(range<K) {
//				for(int i=1; i<=K-range; i++) {
//					int j = i + range;
//					if(range==1) {
//						d[i][j] = size[i] + size[j];
//					}
//					else {
//						int sum = 0;
//						for(int k=i; k<=j; k++)
//							sum += size[k];
//						int min = Integer.MAX_VALUE;
//						for(int k=i; k<j; k++) 
//							min = Integer.min(min, d[i][k]+d[k+1][j]+sum);
//						d[i][j] = min;
//					}
//				}
//				range++;
//			}
			
			
//			for(int i=1; i<=K; i++) {
//				for(int j=1; j<=K; j++)
//					System.out.printf("%5d ",d[i][j]);
//				System.out.println();
//			}
//			output.write(d[1][K]+"\n");
			
//			top-down ���
			for(int i = 1; i <= K; i++)
				Arrays.fill(d[i], -1);
			output.write(go(1, K) + "\n");
		}
		output.flush();
	}
	
	private static int go(int i, int j) {
		if(i == j)
			return 0;
		if(d[i][j] != -1)
			return d[i][j];
		int result = -1;
		int sum = 0;
		for(int k = i; k <= j; k++)
			sum += size[k];
		for(int k = i; k <= j-1; k++) {
			int temp = go(i, k) + go(k+1, j) + sum;
			if(result == -1 || result > temp)
				result = temp;
		}
		d[i][j] = result;
		return result;
	}
	
}
