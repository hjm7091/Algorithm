package Baekjoon.BFS.q4991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class pair{
	int x,y;
	pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int w,h;
	static char[][] room;
	static ArrayList<pair> robo_dirt;
	static int[][] robo_dirt_dist;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result;
	static boolean flag;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			room = new char[h][w];
			robo_dirt = new ArrayList<>();
			flag = false;
			if(w==0 && h==0)
				break;
			for(int i=0; i<h; i++) {
				String tmp = input.readLine();
				room[i] = tmp.toCharArray();
				for(int j=0; j<w; j++) {
					if(room[i][j]=='o')
						robo_dirt.add(0,new pair(i,j));
					if(room[i][j]=='*')
						robo_dirt.add(new pair(i,j));
				}
			}
			
			int size = robo_dirt.size();
			robo_dirt_dist = new int[size][size]; //한점에서 한점으로의 거리를 저장
			for(int i=0; i<size; i++) {
				pair src = robo_dirt.get(i);
				int[][] dist = bfs(src); //한점에서 다른 모든점까지의 거리를 bfs로 구함
				for(int j=0; j<size; j++) {
					pair dst = robo_dirt.get(j);
					robo_dirt_dist[i][j] = dist[dst.x][dst.y];
//					print(robo_dirt_dist);
					if(robo_dirt_dist[i][j] == -1) {
						flag = true;
						break;
					}
				}
				if(flag)
					break;
			}
			
			if(flag) { //도달할수 없다면 -1출력
				output.write("-1\n");
				continue;
			}
			else { //도달할수 있으면 robo_dirt_dist배열에서 dfs로 최단 거리 구함
				visited = new boolean[size];
				result = Integer.MAX_VALUE;
				dfs(0,0,0);
				output.write(result+"\n");
			}
			
		}
		output.flush();
	}
	
	public static void dfs(int src, int index, int sum) {
		if(index==robo_dirt.size()-1) {
			result = Integer.min(result, sum);
			return;
		}
		for(int dst=1; dst<robo_dirt.size(); dst++) {
			if(visited[dst])
				continue;
			else {
				visited[dst] = true;
				dfs(dst, index+1, sum+robo_dirt_dist[src][dst]);
				visited[dst] = false;
			}
		}
	}
	
	public static int[][] bfs(pair p){
		int[][] move = new int[h][w];
		boolean[][] check = new boolean[h][w];
		for(int i=0; i<h; i++) { 
			Arrays.fill(move[i], -1);
			Arrays.fill(check[i], false);
		}
		Queue<pair> q = new LinkedList<>(); 
		q.add(p);
		move[p.x][p.y] = 0;
		check[p.x][p.y] = true;
		while(!q.isEmpty()) {
			pair now = q.remove();
			for(int i=0; i<4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				if(nextX>=0 && nextX<h && nextY>=0 && nextY<w && !check[nextX][nextY]) {
					check[nextX][nextY] = true;
					if(room[nextX][nextY]=='x')
						continue;
					else {
						move[nextX][nextY] = move[now.x][now.y] + 1;
						q.add(new pair(nextX,nextY));
					}
				}
			}
		}
		
		return move;
	}
	
}
