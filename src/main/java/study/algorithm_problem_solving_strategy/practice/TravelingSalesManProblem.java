package study.algorithm_problem_solving_strategy.practice;
import java.util.ArrayList;
import java.util.Arrays;

public class TravelingSalesManProblem {

	static int n = 5;
	static int[][] dist = { {0,4,7,2,6},
							{4,0,2,1,7},
							{7,2,0,3,8},
							{2,1,3,0,1},
							{6,7,8,1,0}};
	static boolean[] visited;
	static int currentLength;
	static ArrayList<Integer> path;
	
	public static void main(String[] args) {
		visited = new boolean[n];
		currentLength = 0;
		path = new ArrayList<>(n);
		Arrays.fill(visited, false);
		path.add(0);
		int result = shortestPath(0, path, visited, currentLength);
	}
	
	public static int shortestPath(int depth, ArrayList<Integer> path, boolean[] visited, int currentLength) {
		if(depth+1 == n)
			return currentLength + dist[path.get(path.size()-1)][path.get(0)];
		int ret = Integer.MAX_VALUE;
		for(int next=1; next<n; next++) {
			if(visited[next])
				continue;
			int here = path.get(depth);
			path.add(next);
			visited[next] = true;
			int cand = shortestPath(depth+1, path, visited, currentLength + dist[here][next]);
			ret = Integer.min(ret, cand);
			for(int i=0; i<path.size(); i++)
				System.out.print(path.get(i) + " ");
			System.out.print("length->" + ret);
			System.out.println();
			visited[next] = false;
			path.remove(path.size()-1);
		}
		return ret;
	}

}
