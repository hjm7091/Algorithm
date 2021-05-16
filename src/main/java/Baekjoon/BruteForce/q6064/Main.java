package Baekjoon.BruteForce.q6064;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(input.readLine());
		while (T-- > 0) {
			String[] data = input.readLine().split(" ");
			int M = Integer.parseInt(data[0]);
			int N = Integer.parseInt(data[1]);
			int x = Integer.parseInt(data[2]) - 1;
			int y = Integer.parseInt(data[3]) - 1;
			boolean existAnswer = false;
			for(int k = x; k < (M*N); k+=M) {
				if(k%N == y) {
					output.write(k+1 + "\n");
					existAnswer = true;
					break;
				}
			}
			if(!existAnswer)
				output.write("-1\n");
		}
		output.flush();
	}

}
