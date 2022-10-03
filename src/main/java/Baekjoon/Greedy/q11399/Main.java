package Baekjoon.Greedy.q11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); s.nextLine();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = s.nextInt();
        }
        Arrays.sort(costs);
        int result = 0, tmpSum = 0;
        for (int i = 0; i < n; i++) {
            tmpSum += costs[i];
            result += tmpSum;
        }
        System.out.println(result);
    }

}
