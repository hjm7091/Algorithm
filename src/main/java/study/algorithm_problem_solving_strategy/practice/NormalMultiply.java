package study.algorithm_problem_solving_strategy.practice;
import java.util.Arrays;

public class NormalMultiply {
	static int[] c;
	
	public static void main(String[] args) {
		int[] a = {3, 2, 1};
		int[] b = {6, 5, 4};
		multiply(a,b);
		for(int i=0; i<c.length; i++) 
			System.out.print(c[i]+" ");
	}
	
	public static void multiply(int[] a, int[] b) {
		c = new int[a.length+b.length+1];
		Arrays.fill(c, 0);
		for(int i=0; i<a.length; i++)
			for(int j=0; j<b.length; j++)
				c[i+j] += a[i] * b[j];
		normalize(c);
	}
	
	public static void normalize(int[] c) {
		for(int i=0; i<c.length; i++) {
			if(c[i+1] == 0)
				break;
			c[i+1] += c[i]/10;
			c[i] = c[i]%10;
		}
	}

}
