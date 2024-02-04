package baekjoon.brute_force.q1019;

import java.util.Scanner;

public class Main {

	static int start, end;
	static long[] count = new long[10];
	static int unit = 1;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		start = 1;
		end = input.nextInt();
		
		while(start <= end) {
			
			while(start % 10 != 0 && start <= end) {
				countNum(start);
				start++;
			}
			
			if(start > end)
				break;
			
			while(end % 10 != 9 && start <= end) {
				countNum(end);
				end--;
			}
			
			start /= 10;
			end /= 10;
			
			for(int i = 0; i < 10; i++) {
				count[i] += (end - start + 1) * unit;
			}
			
			unit *= 10;
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.print(count[i] + " ");
		}
		
		input.close();
	}
	
	private static void countNum(int num) {
		while(num > 0) {
			count[num % 10] += unit;
			num /= 10;
		}
	}

}
