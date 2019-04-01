import java.util.ArrayList;
import java.util.Arrays;

public class travelingSalesManProblem {

	static int n = 5;
	static int[][] dist = { {0,4,7,2,6}, //두 도시 간의 거리를 저장하는 배열 
							{4,0,2,1,7},
							{7,2,0,3,8},
							{2,1,3,0,1},
							{6,7,8,1,0}};
	static boolean[] visited; //각 도시의 방문 여부
	static int currentLength;
	static ArrayList<Integer> path; //지금까지 만든 경로
	
	public static void main(String[] args) {
		visited = new boolean[n];
		currentLength = 0;
		path = new ArrayList<>(n);
		Arrays.fill(visited, false);
		path.add(0); //시작점을 0으로 설정
		int result = shortestPath(0, path, visited, currentLength);
		System.out.println("모든 도시를 방문하는 최단 거리는 " + result);
	}
	
	public static int shortestPath(int depth, ArrayList<Integer> path, boolean[] visited, int currentLength) {
		if(depth+1 == n) //기저 사례:마지막 도시까지 확인했으면 시작 도시로 돌아가고 종료 
			return currentLength + dist[path.get(path.size()-1)][path.get(0)];
		int ret = Integer.MAX_VALUE;
		for(int next=1; next<n; next++) { //다음 방문할 도시를 전부 시도
			if(visited[next])
				continue;
			int here = path.get(depth);
			path.add(next);
			visited[next] = true;
			//나머지 경로를 재귀 호출을 통해 완성하고 가장 짧은 경로의 길이를 찾는다.
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
