import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Picnic {
	
	static int n; //학생 수
	static int m; //친구 쌍의 수
	static boolean[][] areFriends = new boolean[10][10]; //친구인 두 학생의 번호에 따라 true와 false를 정해줌
	static boolean[] taken = new boolean[10]; //i번째 학생이 짝을 이미 찾았으면 true, 아니면 false
	static int C; //테스트 케이스 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		C = Integer.parseInt(input.readLine());
		for(int c=0; c<C; c++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			Arrays.fill(taken, false); //한번에 초기화
			for(int i=0; i<10; i++) //한번에 초기화
				Arrays.fill(areFriends[i], false);
			String str = input.readLine();
			String array[] = str.split(" ");
			for(int i=0; i<array.length; i+=2) {
				int x = Integer.parseInt(array[i]);
				int y = Integer.parseInt(array[i+1]);
				areFriends[x][y]=true;  //0과 1, 1과 0은 같은 경우이므로 둘다 true로 바꿔야한다.
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
