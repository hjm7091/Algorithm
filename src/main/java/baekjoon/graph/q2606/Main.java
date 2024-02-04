package baekjoon.graph.q2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static final int START = 1;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(bufferedReader.readLine());
            final int K = Integer.parseInt(bufferedReader.readLine());
            List<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < K; i++) {
                final String[] split = bufferedReader.readLine().split(" ");
                final int a = Integer.parseInt(split[0]);
                final int b = Integer.parseInt(split[1]);
                graph[a].add(b);
                graph[b].add(a);
            }

            System.out.println(findInfectedCountUsingBfs(graph));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    private static int findInfectedCountUsingBfs(List<Integer>[] graph) {
        int count = 0;
        boolean[] visit = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        visit[START] = true;
        queue.add(START);
        while(!queue.isEmpty()) {
            final int current = queue.poll();
            for (final int next : graph[current]) {
                if (!visit[next]) {
                    visit[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }
        return count;
    }

}
