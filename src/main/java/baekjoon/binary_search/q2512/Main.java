package baekjoon.binary_search.q2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] budget = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        int start = 0;
        int end = Arrays.stream(budget).summaryStatistics().getMax();
        int max = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int assignedBudget = calAssignedBudget(budget, mid);

//            System.out.println("mid : " + mid + ", assignedBudget : " + assignedBudget);

            if (assignedBudget <= M) {
                start = mid + 1;
                max = Integer.max(max, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(max);
    }

    private static int calAssignedBudget(int[] budgets, int limit) {
        int result = 0;
        for (int budget : budgets) {
            result += Math.min(limit, budget);
        }
        return result;
    }

}
