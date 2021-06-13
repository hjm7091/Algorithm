package Programmers.DevMatching2021.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Point {
    int x, y;
    int value;

    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Solution {

    private int[][] board;

    public int[] solution(int rows, int columns, int[][] queries) {
        init(rows, columns);

        List<Integer> nums = new ArrayList<>();

        for (int[] query : queries) {
            int fromX = query[0], fromY = query[1], fromVal = board[fromX][fromY];
            int toX = query[2], toY = query[3], toVal = board[toX][toY];
            int minimumNum = rotate(new Point(fromX, fromY, fromVal), new Point(toX, toY, toVal));
//            printBoard();
            nums.add(minimumNum);
        }

        return nums.stream().mapToInt(Integer::intValue).toArray();
    }

    private void printBoard() {
        for (int x = 1; x < board.length; x++) {
            for(int y = 1; y < board[x].length; y++) {
                System.out.printf("%2d ", board[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private int rotate(Point from, Point to) {

        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

        int dir = 0;
        Point prev = from;
        Point next;
        int min = prev.value;

        do {

            if ((prev.x == from.x && prev.y == to.y)
                    || (prev.x == to.x && prev.y == to.y)
                        || (prev.x == to.x && prev.y == from.y)) dir++;

            int nx = prev.x + dx[dir], ny = prev.y + dy[dir], nVal = board[nx][ny];
            next = new Point(nx, ny, nVal);
            board[next.x][next.y] = prev.value;
            prev = next;
            min = Integer.min(min, prev.value);

        } while (!prev.equals(from));

        return min;
    }

    private void init(int rows, int columns) {
        board = new int[rows + 1][columns + 1];
        int value = 1;
        for (int x = 1; x <= rows; x++) {
            for(int y = 1; y <= columns; y++) {
                board[x][y] = value++;
            }
        }
    }

}
