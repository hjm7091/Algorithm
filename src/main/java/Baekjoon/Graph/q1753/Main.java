package Baekjoon.Graph.q1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int num, weight;
    public Edge(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {

    private int start;
    private final int INF = 3000000;
    private List<Edge>[] graph;
    private int[] dist;

    public static void main(String[] args) {
        new Main().solve();
    }

    public void solve() {
        input();
        findOutMinimumPath();
        for (int d : dist) {
            String result = d == INF ? "INF" : Integer.toString(d);
            System.out.println(result);
        }
    }

    private void findOutMinimumPath() {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        dist[start] = 0;
//        print("===start===");
        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            for (Edge next : graph[now.num]) {
                if (dist[next.num] > dist[now.num] + next.weight) {
                    dist[next.num] = dist[now.num] + next.weight;
                    queue.add(new Edge(next.num, dist[next.num]));
                }
            }

//            print("===after move from " + now.num + "===");
        }
    }

    private void print(String msg) {
        System.out.println(msg);
        System.out.println("dist : " + Arrays.toString(dist));
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    private void input() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = bufferedReader.readLine().split(" ");
            int V = Integer.parseInt(firstLine[0]);
            int E = Integer.parseInt(firstLine[1]);
            start = Integer.parseInt(bufferedReader.readLine()) - 1;
            dist = new int[V];
            graph = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                dist[i] = INF;
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                String[] edge = bufferedReader.readLine().split(" ");
                int u = Integer.parseInt(edge[0]), v = Integer.parseInt(edge[1]), w = Integer.parseInt(edge[2]);
                graph[u - 1].add(new Edge(v - 1, w));
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

}
