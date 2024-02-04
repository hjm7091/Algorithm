package programmers.level3.fill_the_puzzle_pieces;

import java.util.*;
import java.util.stream.Collectors;

class Point {
    final int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean isRangeOver(int x, int y, int min, int max) {
        return x < min || x >= max || y < min || y >= max;
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

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}

class Block {
    final List<Point> points;
    int lenX = 1, lenY = 1;

    Block(List<Point> points) {
        this.points = Objects.requireNonNull(points).stream().sorted((p1, p2) -> {
            if (p1.x == p2.x) return Integer.compare(p1.y, p2.y);
            return Integer.compare(p1.x, p2.x);
        }).collect(Collectors.toList());

        for (Point point : points) {
          lenX = Integer.max(lenX, point.x + 1);
          lenY = Integer.max(lenY, point.y + 1);
        }
    }

    public Block rotateClockWay() {
        List<Point> points = new ArrayList<>();
        for (Point point : this.points) {
            Point newPoint = new Point(point.y, lenX - 1 - point.x);
            points.add(newPoint);
        }
        return new Block(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return points.equals(block.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Block{" + "points=" + points + ", lenX=" + lenX + ", lenY=" + lenY + '}';
    }
}

public class Solution {

    public int solution(int[][] game_board, int[][] table) {
        reverse(game_board);

        List<Block> gameBoardBlocks = findBlocks(game_board);
        List<Block> tableBlocks = findBlocks(table);

        int answer = 0;

        outerLoop : for (Block gameBoardBlock : gameBoardBlocks) {
            ListIterator<Block> tableBlocksIterator = tableBlocks.listIterator();
            while (tableBlocksIterator.hasNext()) {
                Block tableBlock = tableBlocksIterator.next();

                if (gameBoardBlock.equals(tableBlock)) {
                    answer += gameBoardBlock.points.size();
                    tableBlocksIterator.remove();
                    continue outerLoop;
                }

                Block rotatedBlock = tableBlock.rotateClockWay();
                while (!tableBlock.equals(rotatedBlock)) {
                    if (gameBoardBlock.equals(rotatedBlock)) {
                        answer += gameBoardBlock.points.size();
                        tableBlocksIterator.remove();
                        continue outerLoop;
                    }
                    rotatedBlock = rotatedBlock.rotateClockWay();
                }
            }
        }

        return answer;
    }

    private List<Block> findBlocks(int[][] arr) {
        List<Block> blocks = new ArrayList<>();
        boolean[][] visit = new boolean[arr.length][arr.length];
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                if (arr[x][y] != 0 && !visit[x][y]) {
                    Point start = new Point(x, y);
                    blocks.add(new Block(findPoints(start, arr, visit)));
                }
            }
        }
        return blocks;
    }

    private List<Point> findPoints(Point start, int[][] arr, boolean[][] globalVisit) {
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        int size = arr.length;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[size][size];
        queue.add(start);
        visit[start.x][start.y] = true;

        List<Point> points = new ArrayList<>();
        int minX = start.x, minY = start.y;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int dir = 0; dir < dx.length; dir++) {
                int nx = point.x + dx[dir], ny = point.y + dy[dir];
                if (Point.isRangeOver(nx, ny, 0, size)) continue;
                if (visit[nx][ny] || arr[nx][ny] == 0) continue;

                visit[nx][ny] = true;
                globalVisit[nx][ny] = true;
                minX = Integer.min(minX, nx);
                minY = Integer.min(minY, ny);
                queue.add(new Point(nx, ny));
            }
        }

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (visit[x][y]) {
                    points.add(new Point(x - minX, y - minY));
                }
            }
        }

        return points;
    }

    private void reverse(int[][] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                arr[x][y] = arr[x][y] == 0 ? 1 : 0;
            }
        }
    }
}
