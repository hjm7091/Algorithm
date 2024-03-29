package study.algorithm_problem_solving_strategy.practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReverseQuadtree {

	static int position;
	static String Quadtree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int c = Integer.parseInt(input.readLine());
		for(int i=0; i<c; i++) {
			position = 0;
			Quadtree = input.readLine();
			output.write(reverse()+"\n");
		}
		output.flush();
		output.close();
		input.close();
	}

	public static String reverse() {
		if(Quadtree.charAt(position)!='x') {
			position++;
			return Quadtree.charAt(position-1)+"";	
		}
		else {
			position++;
			String[] tmp = new String[4];
			
			tmp[0] = reverse();
			tmp[1] = reverse();
			tmp[2] = reverse();
			tmp[3] = reverse();
			
			return "x" + tmp[2] + tmp[3] + tmp[0] + tmp[1];
		}
	}
}
