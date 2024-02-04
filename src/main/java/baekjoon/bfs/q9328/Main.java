package baekjoon.bfs.q9328;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int T, h, w;
	static char[][] map;
	static boolean[][] visit;
	static boolean[] key;
	static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Scanner input = new Scanner(System.in);
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		T = input.nextInt();
		while(T-- > 0) {
			init();
			int result = bfs(new Pair(0, 0));
			output.write(result + "\n");
		}
		output.flush();
		output.close();
		input.close();
	}
	
	private static void init() {
		h = input.nextInt() + 2;
		w = input.nextInt() + 2;
		map = new char[h][w];
		visit = new boolean[h][w];
		key = new boolean[26];
		
		for(int i = 0; i < h; i++) {
			if(i == 0 || i == h-1)
				Arrays.fill(map[i], '.');
			else {
				String temp = input.next();
				temp = '.' + temp + '.';
				map[i] = temp.toCharArray();
			}
		}
		
		String keys = input.next();
		if(keys.charAt(0) != '0') {
			for(int i = 0; i < keys.length(); i++) {
				key[keys.charAt(i) - 'a'] = true;
			}
		}
	}
	
	private static int bfs(Pair start) {
		int result = 0;
		Queue<Pair> q = new LinkedList<>();
		@SuppressWarnings("unchecked")
		Queue<Pair>[] door = new LinkedList[26];
		for(int i = 0; i < 26; i++) {
			door[i] = new LinkedList<>();
		}
		
		q.add(start);
		visit[start.x][start.y] = true;
		while(!q.isEmpty()) {
			Pair now = q.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				if(rangeOver(nx, ny) || visit[nx][ny]) 
					continue;
				char w = map[nx][ny];
				if(w == '*')
					continue;
				visit[nx][ny] = true;
				if(w == '.') {
					q.add(new Pair(nx, ny));
				} else if(w == '$') {
					result++;
					q.add(new Pair(nx, ny));
				} else if(w >= 'A' && w <= 'Z') {
					if(key[w - 'A']) {
						q.add(new Pair(nx, ny));
					} else {
						door[w - 'A'].add(new Pair(nx, ny));
					}
				} else if(w >= 'a' && w <= 'z') {
					q.add(new Pair(nx, ny));
					if(!key[w - 'a']) {
						key[w - 'a'] = true;
						while(!door[w - 'a'].isEmpty()) {
							q.add(door[w - 'a'].poll());
						}
					}
				}
			}
		}
		return result;
	}
	
	private static boolean rangeOver(int x, int y) {
		if(x < 0 || x > h-1 || y < 0 || y > w-1)
			return true;
		return false;
	}

}
