import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class reverseQuadtree {

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
		if(Quadtree.charAt(position)!='x') { //첫 항이 x가 아닌 경우
			position++;
			return Quadtree.charAt(position-1)+"";	
		}
		else { //첫 항이 x인 경우
			position++;
			String[] tmp = new String[4]; //4조각을 담는 그릇
			
			tmp[0] = reverse(); //왼쪽 위 
			tmp[1] = reverse(); //오른쪽 위
			tmp[2] = reverse(); //왼쪽 아래
			tmp[3] = reverse(); //오른쪽 아래
			
			return "x" + tmp[2] + tmp[3] + tmp[0] + tmp[1];
		}
	}
}
