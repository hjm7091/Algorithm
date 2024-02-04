package study.algorithm_problem_solving_strategy.practice;
import java.util.Scanner;

public class FastSum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int result = fastSum(n);
		System.out.println(result);
	}

	public static int fastSum(int n) {
		if(n==1)
			return 1;
		else if(n%2==1)
			return n+fastSum(n-1);
		else
			return 2 * fastSum(n/2) + n * n / 4;
	}
}
