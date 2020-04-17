package q10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, M;
	static int[] nums, sums, count;
	static long result;
	
	public static void main(String[] args) throws IOException {
		init();

		result = count[0];
		for(int i = 0; i < M; i++) {
			result += (long) count[i] * (count[i] - 1) / 2;
		}
		System.out.println(result);
	}
	
	private static void init() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] in = input.readLine().split(" ");
		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);
		nums = new int[N+1];
		sums = new int[N+1];
		count = new int[M];
		in = input.readLine().split(" ");
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(in[i-1]);
			sums[i] = (nums[i] % M + sums[i-1] % M) % M;
			count[sums[i]]++;
		}
		input.close();
	}

}
