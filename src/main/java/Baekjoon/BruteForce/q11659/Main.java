package Baekjoon.BruteForce.q11659;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N, M;
	static int[] nums, sums;
	static int[] start, end;
	
	public static void main(String[] args) throws IOException {
		init();
		prefixSum();
		printSums();
	}
	
	private static void init() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] info = input.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		nums = new int[N+1];
		sums = new int[N+1];
		start = new int[M];
		end = new int[M];
		info = input.readLine().split(" ");
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(info[i-1]);
		}
		for(int i = 0; i < M; i++) {
			info = input.readLine().split(" ");
			start[i] = Integer.parseInt(info[0]);
			end[i] = Integer.parseInt(info[1]);
		}
		input.close();
	}
	
	private static void prefixSum() {
		for(int i = 1; i <= N; i++) {
			if(i == 1)
				sums[i] = nums[i];
			else
				sums[i] = sums[i-1] + nums[i];
		}
	}
	
	private static void printSums() throws IOException {
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < M; i++) {
			int sum = sums[end[i]] - sums[start[i] - 1];
			output.write(sum + "\n");
		}
		output.flush();
		output.close();
	}

}
