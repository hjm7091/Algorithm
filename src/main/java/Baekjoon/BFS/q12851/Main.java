package Baekjoon.BFS.q12851;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N,K;
	static boolean[] check;
	static int[] move;
	static int[] count;
	static final int MAX = 100001;
	
	public static void main(String[] args) {
		init();
		bfs();
		System.out.println(move[K]);
		System.out.println(count[K]);
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		check = new boolean[MAX];
		move = new int[MAX];
		count = new int[MAX];
		input.close();
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		check[N] = true;
		move[N] = 0;
		count[N] = 1;
		while(!q.isEmpty()) {
			int now = q.remove();
			for(int next : new int[] {now-1, now+1, 2*now}) {
				if(next >= 0 && next < MAX) {
					if(!check[next]) {
						q.add(next);
						check[next] = true;
						move[next] = move[now] + 1;
						count[next] = count[now];
					}
					else if(move[next] == move[now]+1) {
						count[next] += count[now];
					}
				}
			}
		}
	}

}
