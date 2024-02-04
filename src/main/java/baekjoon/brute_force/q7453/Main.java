package baekjoon.brute_force.q7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n;
	static int[] A, B, C, D;
	static int[] first, second;
	
	public static void main(String[] args) throws IOException{
		init();
		System.out.println(findAnswer());
	}
	
	private static void init() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(input.readLine());
		A = new int[n]; B = new int[n]; C = new int[n]; D = new int[n];
		for(int i = 0; i < n; i++) {
			String[] line = input.readLine().split(" ");
			A[i] = Integer.parseInt(line[0]);
			B[i] = Integer.parseInt(line[1]);
			C[i] = Integer.parseInt(line[2]);
			D[i] = Integer.parseInt(line[3]);
		}
		first = new int[n * n];
		second = new int[n * n];
		int index = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				first[index] = A[i] + B[j];
				second[index] = C[i] + D[j];
				index++;
			}
		}
	}
	
	private static long findAnswer() {
		Arrays.sort(second);
		long result = 0;
//		System.out.println(Arrays.toString(first));
//		System.out.println(Arrays.toString(second));
		for(int num : first) {
			int lower = lower_bound(second, -num);
			int upper = upper_bound(second, -num);
//			System.out.println("lower:" + lower + " upper:" + upper);
			result += upper - lower;
		}
		return result;
	}
	
	static int upper_bound(int[] a, int val) {
        int left = 0;
        int right = a.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] <= val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
	
    static int lower_bound(int[] a, int val) {
        int left = 0;
        int right = a.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
