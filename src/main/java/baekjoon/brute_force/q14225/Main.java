package baekjoon.brute_force.q14225;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] S;
	static boolean[] check;
	static boolean[] visit = new boolean[2000001];
	static ArrayList<Integer> choice = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		S = new int[N];
		check = new boolean[N];
		for(int i=0; i<N; i++) {
			S[i] = input.nextInt();
			visit[S[i]] = true;
		}
		for(int pick=2; pick<=N; pick++) {
			makeSequence(0, 0, pick);
		}
		int result = -1;
		for(int i=1; i<=2000000; i++) {
			if(!visit[i]) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		input.close();
	}

	public static void makeSequence(int index, int sum, int pick) {
		if(choice.size()==pick) {
			visit[sum] = true;
			return;
		}
		for(int i=index; i<N; i++) {
			if(!check[i]) {
				check[i] = true;
				choice.add(S[i]);
				makeSequence(i+1, sum+S[i], pick);
				choice.remove(choice.size()-1);
				check[i] = false;
			}
		}
	}
	
}
