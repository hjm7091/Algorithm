package Programmers.sk2022.problem2;

class Point {

    private static final int[] clockDx = {0, 1, 0, -1}, clockDy = {1, 0, -1, 0};
    private static final int[] nonClockDx = {0, 1, 0, -1}, nonClockDy = {-1, 0, 1, 0};
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dir, boolean clockwise) {
        this.x += clockwise ? clockDx[dir] : nonClockDx[dir];
        this.y += clockwise ? clockDy[dir] : nonClockDy[dir];
    }

    @Override
    public String toString() {
        return "[x : " + x + ", y : " + y + "]";
    }
}

public class Solution {

    public int[][] solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];
        Point[] startPoints = clockwise ?
        new Point[] {
            new Point(0, 0),
            new Point(0, n - 1),
            new Point(n - 1, n - 1),
            new Point(n - 1, 0)
        } :
        new Point[] {
            new Point(0, n - 1),
            new Point(0, 0),
            new Point(n - 1, 0),
            new Point(n - 1, n - 1),
        };

        int dir = 0;
        for (Point startPoint : startPoints) {
            fill(startPoint, 1, dir, n, answer, clockwise);
            dir = nextDir(dir);
        }

        return answer;
    }

    private void fill(Point start, int value, int dir, int n, int[][] arr, boolean clockwise) {
        Point p = new Point(start.x, start.y);
        arr[p.x][p.y] = value++;

        if (n == 1 || n == 2) return;

        int count = 0;
        while (count++ < n - 2) {
            p.move(dir, clockwise);
            arr[p.x][p.y] = value++;
        }

        dir = nextDir(dir);
        p.move(dir, clockwise);

        fill(p, value, dir, n - 2, arr, clockwise);
    }

    private int nextDir(int dir) {
        return dir + 1 > 3 ? 0 : dir + 1;
    }
}