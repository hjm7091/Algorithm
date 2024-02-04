package programmers.level3.island_connection;

import java.util.Arrays;

public class Solution2 {

	int[] island;
	int sum;
	
	public int solution(int n, int[][] costs) {
		init(n);
		Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
		makeMinimumSpanningTreeUsingKruskal(costs);
        return sum;
    }
	
	private void init(int n) {
		island = new int[n];
		for(int idx = 0; idx < n; idx++)
			island[idx] = idx;
	}
	
	private void makeMinimumSpanningTreeUsingKruskal(int[][] costs) {
		for(int idx = 0; idx < costs.length; idx++) {
			int start = find(costs[idx][0]);
			int end = find(costs[idx][1]);
			int cost = costs[idx][2];
			
			if(start != end) {
				island[start] = end;
				sum += cost;
			}
		}
	}
	
	private int find(int node) {
		if(node == island[node])
			return node;
		else
			return find(island[node]);
	}
	
	public static void main(String[] args) {
		int[][] costs1 = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int[][] costs2 = {{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4}};
		int[][] costs3 = {{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10},{1,2,2},{2,5,3},{4,5,4}};
		Solution2 s = new Solution2();
		System.out.println(s.solution(4, costs2));
	}

}
