package baekjoon.implementation.q17779;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] A;
    static int[][] division;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        A = new int[N + 1][N + 1];
        division = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                A[i][j] = input.nextInt();
        System.out.println(solve());
    }

    private static int solve() {
        int result = Integer.MAX_VALUE;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (rangeOver(x, y, d1, d2)) continue;
                        for (int i = 1; i <= N; i++) Arrays.fill(division[i], 0);
                        setDivision5(x, y, d1, d2);
                        setDivisionRest(x, y, d1, d2);
                        result = Integer.min(result, calMinMaxDiff(false));
//                        if (x == 1 && y == 2 && d1 == 1 && d2 == 7) {
//                            print(division);
//                            calMinMaxDiff(true);
//                        }
                    }
                }
            }
        }
        return result;
    }

    private static int calMinMaxDiff(boolean print) {
        int[] v = new int[6];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (division[i][j] == 1) v[1] += A[i][j];
                if (division[i][j] == 2) v[2] += A[i][j];
                if (division[i][j] == 3) v[3] += A[i][j];
                if (division[i][j] == 4) v[4] += A[i][j];
                if (division[i][j] == 5) v[5] += A[i][j];
            }
        }
        int max = v[1];
        int min = v[1];
        for (int i = 2; i < v.length; i++) {
            if (v[i] > max) max = v[i];
            if (v[i] < min) min = v[i];
        }
        if (print) System.out.println(Arrays.toString(v));
        return max - min;
    }

    private static void setDivisionRest(int x, int y, int d1, int d2) {
        for (int r = 1; r < x + d1; r++) {
            for (int c = 1; c <= y; c++) {
                if (division[r][c] == 0) {
                    division[r][c] = 1;
                }
            }
        }
        for (int r = 1; r <= x + d2; r++) {
            for (int c = y + 1; c <= N; c++) {
                if (division[r][c - 1] == 0 && division[r + 1][c] == 0) continue;
                if (division[r][c] == 0) {
                    division[r][c] = 2;
                }
            }
        }
        for (int r = x + d1; r <= N; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {
                if (division[r - 1][c] == 0 && division[r][c + 1] == 0) continue;
                if (division[r][c] == 0) {
                    division[r][c] = 3;
                }
            }
        }
        for (int r = x + d2 + 1; r <= N; r++) {
            for (int c = y - d1 + d2; c <= N; c++) {
                if (division[r][c] == 0) {
                    division[r][c] = 4;
                }
            }
        }
    }

    private static void print(int[][] map) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void setDivision5(int x, int y, int d1, int d2) {
        for (int s = 0; s <= d1; s++) division[x + s][y - s] = 5;
        for (int s = 0; s <= d2; s++) division[x + s][y + s] = 5;
        for (int s1 = d1, s2 = -d1; s1 <= d1 + d2; s1++, s2++) division[x + s1][y + s2] = 5;
        for (int s1 = d2, s2 = d2; s1 <= d2 + d1; s1++, s2--) division[x + s1][y + s2] = 5;

        for (int i = x; i <= x + d1 + d2; i++) {
            int start = 0;
            int end = 0;
            for (int j = 1; j <= N; j++) {
                if (division[i][j] == 5) {
                    start = j;
                    break;
                }
            }
            for (int j = start + 1; j <= N; j++) {
                if (division[i][j] == 5) {
                    end = j;
                    break;
                }
            }
            if (start < end) {
                for (int j = start; j <= end; j++) {
                    division[i][j] = 5;
                }
            }
        }
    }

    private static boolean rangeOver(int x, int y, int d1, int d2) {
        if (x + d1 > N || x + d2 > N || x + d1 + d2 > N || y - d1 < 1 || y + d2 > N || y - d1 + d2 > N || y - d1 + d2 < 1)
            return true;
        return false;
    }

}
