package baekjoon.dp.q24416;

import java.util.Scanner;

public class Main {

    private static int cnt1, cnt2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib1(n); fib2(n);
        System.out.println(cnt1 + " " + cnt2);
    }

    private static int fib1(int n) {
        if (n == 1 || n == 2) {
            cnt1++;
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    private static int fib2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            cnt2++;
        }
        return dp[n];
    }
}
