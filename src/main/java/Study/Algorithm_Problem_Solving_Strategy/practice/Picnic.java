package Study.Algorithm_Problem_Solving_Strategy.practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Picnic {
	
	static int n;
	static int m;
	static boolean[][] areFriends = new boolean[10][10];
	static boolean[] taken = new boolean[10];
	static int C;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		C = Integer.parseInt(input.readLine());
		for(int c=0; c<C; c++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			Arrays.fill(taken, false);
			for(int i=0; i<10; i++)
				Arrays.fill(areFriends[i], false);
			String str = input.readLine();
			String array[] = str.split(" ");
			for(int i=0; i<array.length; i+=2) {
				int x = Integer.parseInt(array[i]);
				int y = Integer.parseInt(array[i+1]);
				areFriends[x][y]=true;
				areFriends[y][x]=true;
			}
			int result = countPairings(taken);
			output.write(result+"\n");
		}
		output.flush();
		output.close();
	}
	
	public static int countPairings(boolean[] taken) {
		int firstFree = -1;
		for(int i=0; i<n; i++) {
			if(!taken[i]) {
				firstFree = i;
				break;
			}
		}
			
		if(firstFree==-1) return 1;
		int ret = 0;
		for(int pairwith=firstFree+1; pairwith<n; pairwith++)
			if(!taken[pairwith]&&areFriends[firstFree][pairwith]) {
				taken[firstFree]=taken[pairwith]=true;
				ret += countPairings(taken);
				taken[firstFree]=taken[pairwith]=false;
			}
		return ret;
	}
	
}
