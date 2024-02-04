package programmers.level3.farthest_node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	private List<Integer>[] adj;
	private Integer[] distances;
	
	public int solution(int n, int[][] edge) {
		init(n, edge);
		calculateDistanceFromOne(0, 0);
		System.out.println(Arrays.toString(distances));
		Arrays.sort(distances, Collections.reverseOrder());
		System.out.println(Arrays.toString(distances));
        int answer = countFarthestNode(n);
        return answer;
    }
	
	private void init(int n, int[][] edge) {
		distances = new Integer[n];
		adj = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>(); 
			distances[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < edge.length; i++) {
			int from = edge[i][0] - 1;
			int to = edge[i][1] - 1;
			adj[from].add(to);
			adj[to].add(from);
		}
	}
	
	private void calculateDistanceFromOne(int now, int distance) {
		distances[now] = Integer.min(distances[now], distance);
		for(int next : adj[now]) {
			if(distance + 1 < distances[next])
				calculateDistanceFromOne(next, distance + 1);
		}
	}
	
	private int countFarthestNode(int n) {
		int count = 1;
		int farthestDistance = distances[0];
		for(int i = 1; i < n; i++) {
			if(distances[i] == farthestDistance) 
				count++;
			else
				break;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] edge1 = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		int[][] edge2 = {{1,2}};
		System.out.println(s.solution(2, edge2));
	}

}
