import java.util.Scanner;

public class fastSum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int result = FastSum(n);
		System.out.println(result);
	}

	public static int FastSum(int n) {
		if(n==1)
			return 1;
		else if(n%2==1)
			return n+FastSum(n-1);
		else
			return 2 * FastSum(n/2) + n * n / 4;
	}
}
