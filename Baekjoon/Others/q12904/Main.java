package q12904;

import java.util.Scanner;

public class Main {

	static String S, T;
	
	public static void main(String[] args) {
		init();
		System.out.println(makeDecision());
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		S = input.next();
		T = input.next();
		input.close();
	}
	
	private static int makeDecision() {
		int result = 0;
		while(true) {
			if(S.length() == T.length()) {
				if(S.equals(T))
					result = 1;
				break;
			}
			char last = T.charAt(T.length()-1);
			System.out.println(last);
			T = removeLast(T);
			if(last == 'B')
				T = reverse(T);
		}
		return result;
	}
	
	private static String removeLast(String str) {
		return str.substring(0, str.length()-1);
	}
	
	private static String reverse(String str) {
		return (new StringBuffer(str)).reverse().toString();
	}

}
