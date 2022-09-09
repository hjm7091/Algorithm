package Dijkstra;

import java.util.*;

/**
 * 참고 : https://terianp.tistory.com/144
 */
public class Dijkstra {

    private final int n;

    private final List<List<Edge>> graph = new ArrayList<>();

    public Dijkstra(int n, int[][] paths) {
        this.n = n;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0]).add(new Edge(path[1], path[2]));
        }
    }

    public int[] execute(int start) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            System.out.println("edge : " + edge);

            if (edge.cost > distances[edge.num]) {
                System.out.println("duplication visiting happened! edge : " + edge);
                continue;
            }

            for (Edge next : graph.get(edge.num)) {
                if (next.cost + edge.cost < distances[next.num]) {
                    distances[next.num] = next.cost + edge.cost;
                    pq.offer(new Edge(next.num, distances[next.num]));
                }
            }
        }

        return distances;
    }

    private static class Edge implements Comparable<Edge> {
        int num, cost;
        public Edge(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return String.format("(num : %d, cost : %d)", this.num, this.cost);
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.cost, e.cost);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] paths = {
            {1, 2, 12},
            {1, 3, 4},
            {2, 1, 2},
            {2, 3, 5},
            {2, 5, 5},
            {3, 4, 5},
            {4, 2, 2},
            {4, 5, 5},
            {6, 4, 5},
        };
        int[] distances = new Dijkstra(n, paths).execute(1);
        System.out.println(Arrays.toString(distances));
    }

}
