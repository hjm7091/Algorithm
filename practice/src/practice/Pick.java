package practice;
import java.util.ArrayList;
import java.util.Scanner;

public class Pick {

	static Scanner input;
	static int n;
	static ArrayList<Integer> picked;
	static int topick;
	static int total;
		
	public static void main(String[] args) {
		input = new Scanner(System.in);
		n = input.nextInt();
		picked = new ArrayList<>(n);
		topick = 0;
		total = 0;
		pick(n,0,picked,1);
		System.out.println(total);
	}
	
	public static void pick(int n, int next, ArrayList<Integer> picked, int topick) {
		if(topick==0) {
			total++;
			return;
		}
		int smallest = next==0 ? 0 : picked.get(next-1)+1;
		for(int ne=smallest; ne<n; ++ne) {
			picked.add(ne);
			pick(n,next+1,picked,topick-1);
			picked.remove(next);
		}
	}

}
