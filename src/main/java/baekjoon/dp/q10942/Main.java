package baekjoon.dp.q10942;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] num;
	static int[] S,E;
	static int[][] d;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		init();
		for(int i = 1; i <= M; i++) 
			output.write(go(S[i], E[i]) + "\n");
		output.flush();
		input.close();
		output.close();
	}
	
	private static void init() throws IOException {
		N = Integer.parseInt(input.readLine());
		num = new int[N+1];
		StringTokenizer st = new StringTokenizer(input.readLine());
		for(int i=1; i<=N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(input.readLine());
		S = new int[M+1];
		E = new int[M+1];
		for(int i=1; i<=M; i++) {
			StringTokenizer ST = new StringTokenizer(input.readLine());
			S[i] = Integer.parseInt(ST.nextToken());
			E[i] = Integer.parseInt(ST.nextToken());
		}
		d = new int[2001][2001];
		for(int i = 0; i < 2001; i++) {
			Arrays.fill(d[i], -1);
		}
	}
	
	private static int go(int x, int y) {
		if(x == y) 
			return 1;
		if(x+1 == y) {
			if(num[x] == num[y]) 
				return 1;
			else
				return 0;
		}
		if(d[x][y] != -1)
			return d[x][y];
		if(num[x] != num[y]) {
			d[x][y] = 0;
			return d[x][y];
		}
		else {
			d[x][y] = go(x+1, y-1);
			return d[x][y];
		}
	}

}
