package baekjoon.dp.q9184;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][][] dp = new int[51][51][51];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        while (a != -1 || b != -1 || c != -1) {
            results.add(String.format("w(%d, %d, %d) = %d", a, b, c, w(a, b, c)));
            sc.nextLine();
            a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
        }
        results.forEach(System.out::println);
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (dp[a][b][c] != 0) return dp[a][b][c];
        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

}
