package q1748;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int result = 0;
		for(int start = 1, len = 1; start <= N; start *= 10, len++) {
			int end = start * 10 - 1;
			end = end > N ? N : end;
			result += (end - start + 1) * len;
		}
		System.out.println(result);
		input.close();
	}

}
