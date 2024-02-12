package study.cracking_the_coding_interview_6e.array_string.problem1_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution {

    public void setZeros(int[][] arr) {
        List<Point> zeroPoints = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) zeroPoints.add(new Point(i, j));
            }
        }

        for (Point p : zeroPoints) {
            Arrays.fill(arr[p.x], 0);
            for (int row = 0; row < arr.length; row++) {
                arr[row][p.y] = 0;
            }
        }
    }

    private static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
