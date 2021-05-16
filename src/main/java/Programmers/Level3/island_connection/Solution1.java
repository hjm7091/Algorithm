package Programmers.Level3.island_connection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Edge {
	
	int startNode, endNode;
	int cost;
	
	public Edge(int startNode, int endNode, int cost) {
		this.startNode = startNode;
		this.endNode = endNode;
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "start:" + startNode + " end:" + endNode + " cost:" + cost;
	}

}

public class Solution1 {
	
	List<Edge> edges = new ArrayList<Edge>();
	List<Integer>[] node;
	int answer;
	
	Comparator<Edge> comp = new Comparator<Edge>() {

		@Override
		public int compare(Edge e1, Edge e2) {
			return e1.cost - e2.cost;
		}
		
	};
	
	public int solution(int n, int[][] costs) {
		init(n, costs);
		Collections.sort(edges, comp);
		findMinimumEdgeUntilAllNodeConnected();
        return answer;
    }
	
	@SuppressWarnings("unchecked")
	private void init(int n, int[][] costs) {
		node = new ArrayList[n];
		for(int idx = 0; idx < n; idx++)
			node[idx] = new ArrayList<Integer>();
		for(int idx = 0; idx < costs.length; idx++) {
			int startNode = costs[idx][0];
			int endNode = costs[idx][1];
			int cost = costs[idx][2];
			edges.add(new Edge(startNode, endNode, cost));
		}
	}
	
	private void findMinimumEdgeUntilAllNodeConnected() {
		while(!allNodeConnected()) {
			Edge first = edges.get(0);
			
			connectEdge(first);
			
			boolean[] visit = new boolean[node.length];
			if(checkCycle(first.startNode, -1, visit)) 
				unConnectEdge(first);
			else
				answer += first.cost;
			
			edges.remove(first);
		}
	}
	
	private boolean allNodeConnected() {
		
		boolean[] visit = new boolean[node.length];
		
		exploreNodeUsingDfs(0, visit);
		
		for(int num = 0; num < node.length; num++)
			if(visit[num] == false)
				return false;
		return true;
	}
	
	private void exploreNodeUsingDfs(int now, boolean[] visit) {
		visit[now] = true;
		for(int next : node[now]) {
			if(!visit[next]) {
				exploreNodeUsingDfs(next, visit);
			}
		}
	}
	
	private void connectEdge(Edge edge) {
		node[edge.startNode].add(edge.endNode);
		node[edge.endNode].add(edge.startNode);
//		System.out.println(edge.toString());
	}
	
	private boolean checkCycle(int now, int parent, boolean[] visit) {
		visit[now] = true;
		for(int next : node[now]) {
			if(!visit[next]) {
				if(checkCycle(next, now, visit))
					return true;
			}
			else if(next != parent) {
				return true;
			}
		}
		return false;
	}
	
	private void unConnectEdge(Edge edge) {
		node[edge.startNode].remove(node[edge.startNode].size() - 1);
		node[edge.endNode].remove(node[edge.endNode].size() - 1);
	}

	public static void main(String[] args) {
		int[][] costs1 = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int[][] costs2 = {{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4}};
		int[][] costs3 = {{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10},{1,2,2},{2,5,3},{4,5,4}};
		Solution1 s = new Solution1();
		System.out.println(s.solution(6, costs3));
	}

}
