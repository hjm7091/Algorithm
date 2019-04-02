import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class setClock {

	static int INF = 9999, SWITCHES = 10, CLOCKS = 16;
							 //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
							 //linked[i][j] : i번 스위치와 j번 시계가 연결되었는지 확인, 1이면 연결됨, 0이면 연결안됨
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
	
	public static boolean areAligned(int[] clocks) { //모든 시계가 12시를 가리키고 있는지 확인
		boolean result = true;
		for(int i=0; i<clocks.length; i++)
			if(clocks[i]!=12) {
				result = false;
				break;
			}
		return result;
	}

	public static void push(int[] clocks, int swtch) { //swtch번 스위치를 누른다. 
		for(int clock=0; clock<CLOCKS; clock++) {
			if(linked[swtch][clock]==1)
				clocks[clock] += 3;
			if(clocks[clock] == 15)
				clocks[clock] = 3;
		}
	}
	
	//clocks는 시계들의 상태를 저장하고 있는 배열, swtch는 이번에 누를 스위치의 번호
	//스위치들을 눌러서 clocks들을 12시로 맞출 수 있는 최소 횟수를 반환, 만약 불가능하다면 INF 이상의 큰 수를 반환
	public static int solve(int[] clocks, int swtch) {
		if(swtch == SWITCHES)
			return areAligned(clocks) ? 0 : INF;
		int ret = INF;
		//swtch번 스위치를 0번 누르는 경우부터 세 번 누르는 경우까지를 모두 시도함, 네 번 누르는 것은 누르지 않은 것과 같게됨 따라서 세 번까지만 봄 
		for(int cnt=0; cnt<4; cnt++) { 
			ret = Integer.min(ret, cnt + solve(clocks, swtch+1));
			push(clocks, swtch);
		}
		return ret;
	}
}
