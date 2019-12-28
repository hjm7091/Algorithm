package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2422 {

	static int N,M;
	static boolean[][] visit = new boolean[500][500];
	static int result; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bufferedReader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			visit[a][b] = true;
			visit[b][a] = true;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				for(int k=j+1; k<=N; k++) {
					if(canEat(i,j,k))
						result++;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static public boolean canEat(int i, int j, int k) {
		if(visit[i][j] || visit[j][i] || visit[i][k] || visit[k][i] || visit[j][k] || visit[k][j])
			return false;
		return true;
	}
	
}
