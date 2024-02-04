package baekjoon.bfs.q9376;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Prison {

    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    int h, w;
    char[][] prison;

    public Prison(int h, int w, String[] rows) {
        this.h = h + 2;
        this.w = w + 2;
        this.prison = new char[this.h][this.w];
        for (int i = 0; i < this.h; i++) {
            if (i == 0 || i == this.h - 1) {
                Arrays.fill(prison[i], '.');
            } else {
                prison[i] = ("." + rows[i - 1] + ".").toCharArray();
            }
        }
    }

    public int escapePrisoners() {
        Point helper = new Point(0, 0);
        List<Point> prisoners = findPrisoners();

        int[][] move_h = move(helper);
        int[][] move_p1 = move(prisoners.get(0));
        int[][] move_p2 = move(prisoners.get(1));

        int min = Integer.MAX_VALUE;
        for (int x = 1; x < h - 1; x++) {
            for (int y = 1; y < w - 1; y++) {
                if (prison[x][y] == '*') continue;
                if (move_h[x][y] == -1 && move_p1[x][y] == -1 && move_p2[x][y] == -1) continue; // 고립된 지점 제외
                int sum = move_h[x][y] + move_p1[x][y] + move_p2[x][y];
                if (prison[x][y] == '#') min = Math.min(min, sum - 2);
                else min = Math.min(min, sum);
            }
        }

        return min;
    }

    private int[][] move(Point p) {
        int[][] move = new int[h][w];
        for (int i = 0; i < h; i++) Arrays.fill(move[i], -1);
        Deque<Point> q = new LinkedList<>();
        move[p.x][p.y] = 0;
        q.add(p);

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i], ny = now.y + dy[i];
                if (!isRangeOver(nx, ny) && move[nx][ny] == -1) {
                    if (prison[nx][ny] == '.' || prison[nx][ny] == '$') {
                        move[nx][ny] = move[now.x][now.y];
                        q.addFirst(new Point(nx,ny));
                    } else if (prison[nx][ny] == '#') {
                        move[nx][ny] = move[now.x][now.y] + 1;
                        q.addLast(new Point(nx,ny));
                    }
                }
            }
        }

        return move;
    }

    private boolean isRangeOver(int x, int y) {
        return x < 0 || x > h - 1 || y < 0 || y > w - 1;
    }

    private List<Point> findPrisoners() {
        List<Point> prisoners = new ArrayList<>();
        for (int x = 1; x < h - 1; x++) {
            for (int y = 1; y < w - 1; y++) {
                if (prison[x][y] == '$') prisoners.add(new Point(x, y));
            }
        }
        return prisoners;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCount = input.nextInt();
        while (testCount-- > 0) {
            int h = input.nextInt();
            int w = input.nextInt();
            String[] rows = new String[h];
            for (int i = 0; i < h; i++) rows[i] = input.next();
            output.write(new Prison(h, w, rows).escapePrisoners() + "\n");
        }
        output.flush();
    }

}
