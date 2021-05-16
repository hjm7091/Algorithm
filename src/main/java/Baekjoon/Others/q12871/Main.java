package Baekjoon.Others.q12871;

import java.util.Scanner;

public class Main {

	static String str1, str2;
	static String longer, shoter;
	
	public static void main(String[] args) {
		init();
		System.out.println(makeDecision());
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		str1 = input.next();
		str2 = input.next();
		input.close();
	}
	
	private static int makeDecision() {
		int result = 0;
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 == len2) {
			if(str1.equals(str2))
				result = 1;
		} else if(len1 > len2) {
			int g = gcd(len1, len2);
			int l = g * (len1 / g) * (len2 / g);
			expandStr(l);
			if(str1.equals(str2))
				result = 1;
		} else {
			int g = gcd(len2, len1);
			int l = g * (len1 / g) * (len2 / g);
			expandStr(l);
			if(str1.equals(str2))
				result = 1;
		}
			
		return result;
	}
	
	private static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	private static void expandStr(int lcm) {
		StringBuilder sb1 = new StringBuilder(str1);
		StringBuilder sb2 = new StringBuilder(str2);
		String unit1 = sb1.toString(), unit2 = sb2.toString();
		while(sb1.toString().length() < lcm) 
			sb1.append(unit1);
		while(sb2.toString().length() < lcm) 
			sb2.append(unit2);
		str1 = sb1.toString();
		str2 = sb2.toString();
	}

}
