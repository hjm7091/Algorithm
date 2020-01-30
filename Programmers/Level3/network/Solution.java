package network;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	boolean[] visit;
	
	public int solution(int n, int[][] computers) {
		init(n);
        return useBfs(n, computers);
    }
	
	public void init(int n) {
		visit = new boolean[n];
	}
	
	public int useDfs(int n, int[][] computers) {
		int answer = 0;
		for(int now = 0; now < n; now++) {
			if(!visit[now]) {
				answer++;
				dfs(now, n, computers);
			}
		}
		return answer;
	}
	
	public void dfs(int now, int n, int[][] computers) {
		if(visit[now])
			return;
		visit[now] = true;
		for(int next = 0; next < n; next++) {
			if(computers[now][next] == 1)
				dfs(next, n, computers);
		}
	}
	
	public int useBfs(int n, int[][] computers) {
		int answer = 0;
		for(int now = 0; now < n; now++) {
			if(!visit[now]) {
				answer++;
				bfs(now, n, computers);
			}
		}
		return answer;
	}
	
	public void bfs(int now, int n, int[][] computers) {
		Queue<Integer> q = new LinkedList<>();
		q.add(now);
		while(!q.isEmpty()) {
			int cur = q.remove();
			visit[cur] = true;
			for(int next = 0; next < n; next++) {
				if(computers[cur][next] == 1 && !visit[next])
					q.add(next);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] case1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] case2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(s.solution(3, case1));
	}

}
