package q13913;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N,K;
	static boolean[] check;
	static int[] move;
	static int[] from;
	static final int max = 100001;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		check = new boolean[max];
		move = new int[max];
		from = new int[max];
		bfs(N);
		/*for(int i=0; i<=K; i++)
			System.out.print(move[i]+" ");
		System.out.println();
		for(int i=0; i<=K; i++)
			System.out.print(from[i]+" ");
		System.out.println();*/
		System.out.println(move[K]);
//		find_path(K);
		printPath(N, K);
		input.close();
	}
	
	private static void find_path(int n) {
		if(from[n]==0) {
			if(N==0 && K==0)
				System.out.print(N);
			else if(N==0)
				System.out.print(N+" "+n+" ");
			else
				System.out.print(n+" ");
			return;
		}
		find_path(from[n]);
		System.out.print(n+" ");
	}
	
	private static void printPath(int n, int k) {
		if(n != k) {
			printPath(n, from[k]);
		}
		System.out.print(k+" ");
	}
	
	private static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		check[now] = true;
		move[now] = 0;
		while(!q.isEmpty()) {
			int next = q.remove();
			if(2*next<max) {
				if(check[2*next]==false) {
					q.add(2*next);
					check[2*next] = true;
					move[2*next] = move[next] + 1;
					from[2*next] = next; 
				}
			}
			if(next-1>=0) {
				if(check[next-1]==false) {
					q.add(next-1);
					check[next-1] = true;
					move[next-1] = move[next] + 1;
					from[next-1] = next;
				}
			}
			if(next+1<max) {
				if(check[next+1]==false) {
					q.add(next+1);
					check[next+1] = true;
					move[next+1] = move[next] + 1;
					from[next+1] = next;
				}
			}
		}
	}
}
