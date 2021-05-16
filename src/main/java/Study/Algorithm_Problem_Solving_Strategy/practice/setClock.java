package Study.Algorithm_Problem_Solving_Strategy.practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class setClock {

	static int INF = 9999, SWITCHES = 10, CLOCKS = 16;
							 //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
	static int[][] linked = { {1,1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0},
							  {0,0,0,1,0,0,0,1,0,1, 0, 1, 0, 0, 0, 0},
							  {0,0,0,0,1,0,0,0,0,0, 1, 0, 0, 0, 1, 1},
							  {1,0,0,0,1,1,1,1,0,0, 0, 0, 0, 0, 0, 0},
							  {0,0,0,0,0,0,1,1,1,0, 1, 0, 1, 0, 0, 0},
							  {1,0,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 1, 1},
							  {0,0,0,1,0,0,0,0,0,0, 0, 0, 0, 0, 1, 1},
							  {0,0,0,0,1,1,0,1,0,0, 0, 0, 0, 0, 1, 1},
							  {0,1,1,1,1,1,0,0,0,0, 0, 0, 0, 0, 0, 0},
							  {0,0,0,1,1,1,0,0,0,1, 0, 0, 0, 1, 0, 0} };
	static int[] clocks = new int[CLOCKS];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int C = Integer.parseInt(input.readLine());
		for(int i=0; i<C; i++) {
			String L[] = input.readLine().split(" ");
			for(int j=0; j<L.length; j++)
				clocks[j] = Integer.parseInt(L[j]);
			int result = solve(clocks, 0);
			if(result < INF)
				output.write(result+"\n");
			else
				output.write("-1\n");
		}
		output.flush();
		output.close();
	}
	
	public static boolean areAligned(int[] clocks) {
		boolean result = true;
		for(int i=0; i<clocks.length; i++)
			if(clocks[i]!=12) {
				result = false;
				break;
			}
		return result;
	}

	public static void push(int[] clocks, int swtch) {
		for(int clock=0; clock<CLOCKS; clock++) {
			if(linked[swtch][clock]==1)
				clocks[clock] += 3;
			if(clocks[clock] == 15)
				clocks[clock] = 3;
		}
	}
	
	public static int solve(int[] clocks, int swtch) {
		if(swtch == SWITCHES)
			return areAligned(clocks) ? 0 : INF;
		int ret = INF;
		for(int cnt=0; cnt<4; cnt++) {
			ret = Integer.min(ret, cnt + solve(clocks, swtch+1));
			push(clocks, swtch);
		}
		return ret;
	}
}
