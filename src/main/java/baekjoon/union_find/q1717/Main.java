package baekjoon.union_find.q1717;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt(); s.nextLine();
        int[] g = new int[n + 1];
        for (int i = 0; i <= n; i++) g[i] = i;
        List<String> results = new ArrayList<>();
        while (m-- > 0) {
            int[] op = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (op[0] == 0) {
                union(g, op[1], op[2]);
            } else {
                int rootA = find(g, op[1]);
                int rootB = find(g, op[2]);
                results.add(rootA == rootB ? "YES" : "NO");
            }
        }
        results.forEach(System.out::println);
    }

    private static void union(int[] g, int a, int b) {
        int rootA = find(g, a);
        int rootB = find(g, b);
        g[rootB] = rootA;
    }

    private static int find(int[] g, int a) {
        if (g[a] == a) {
            return a;
        } else {
            return g[a] = find(g, g[a]);
        }
    }

}
