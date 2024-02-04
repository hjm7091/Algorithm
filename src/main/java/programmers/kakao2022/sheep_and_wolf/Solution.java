package programmers.kakao2022.sheep_and_wolf;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> graph = new ArrayList<>();
    int result = 0;

    public int solution(int[] info, int[][] edges) {
        buildGraph(info.length, edges);
        dfs(0, 0, 0, graph.get(0), info);
        return result;
    }

    private void dfs(int now, int sheep, int wolf, List<Integer> possibles, int[] info) {
        sheep += info[now] ^ 1; wolf += info[now];

        if (wolf >= sheep) return;
        else result = Integer.max(result, sheep);

        for (int next : possibles) {
            List<Integer> nextPossibles = new ArrayList<>(possibles);
            nextPossibles.removeIf(val -> val == next);
            nextPossibles.addAll(graph.get(next));
            dfs(next, sheep, wolf, nextPossibles, info);
        }
    }

    private void buildGraph(int size, int[][] edges) {
        for (int i = 0; i < size; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) graph.get(edge[0]).add(edge[1]);
    }

}
