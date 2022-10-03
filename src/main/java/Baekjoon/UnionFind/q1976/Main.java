package Baekjoon.UnionFind.q1976;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt(); s.nextLine();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.nextInt();
            }
        }
        s.nextLine();
        int[] arr = union(n, graph);
        List<Integer> paths = new ArrayList<>();
        for (int i = 0; i < m; i++) paths.add(find(arr, s.nextInt()));
        String result = paths.stream().distinct().count() > 1L ? "NO" : "YES";
        System.out.println(result);
    }

    private static int[] union(int n, int[][] graph) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (graph[i][j] == 1) {
                    int rootA = find(arr, i + 1);
                    int rootB = find(arr, j + 1);
                    arr[rootB] = rootA;
                }
            }
        }

        return arr;
    }

    private static int find(int[] arr, int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return arr[a] = find(arr, arr[a]);
        }
    }

}
