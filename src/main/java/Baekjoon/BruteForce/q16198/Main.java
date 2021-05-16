package Baekjoon.BruteForce.q16198;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int N;
	static ArrayList<Integer> energy = new ArrayList<>();
	static int result;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		for(int i=0; i<N; i++)
			energy.add(input.nextInt());
		
		makeSequence(0, energy);
			
		System.out.println(result);
		input.close();
	}
	
	public static void makeSequence(int sum, ArrayList<Integer> copy) {
		if(copy.size()==2) {
			result = Integer.max(result, sum);
			return;
		}
		for(int i=1; i<copy.size()-1; i++) {
			ArrayList<Integer> newCopy = new ArrayList<Integer>();
			newCopy.addAll(copy);
			int newSum = sum + newCopy.get(i-1) * newCopy.get(i+1);
			newCopy.remove(i);
			makeSequence(newSum, newCopy);
		}
	}

}
