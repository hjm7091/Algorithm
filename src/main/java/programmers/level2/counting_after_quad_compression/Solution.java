package programmers.level2.counting_after_quad_compression;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point expandAll(int size) {
        return new Point(this.x + size, this.y + size);
    }

    public Point expandX(int size) {
        return new Point(this.x + size, this.y);
    }

    public Point expandY(int size) {
        return new Point(this.x, this.y + size);
    }

    public Point collapseAll(int size) {
        return new Point(this.x - size, this.y - size);
    }

    public Point collapseX(int size) {
        return new Point(this.x - size, this.y);
    }

    public Point collapseY(int size) {
        return new Point(this.x, this.y - size);
    }

    @Override
    public String toString() {
        return "[x:" + this.x + ", y:" + this.y + "]";
    }
}

class Solution {

    int zero, one;

    public int[] solution(int[][] arr) {
        dfs(arr, new Point(0, 0), new Point(arr.length - 1, arr.length - 1), arr.length);
        return new int[]{zero, one};
    }

    private void dfs(int[][] arr, Point start, Point end, int size) {
        int oneCnt = 0;

        for (int x = start.x; x <= end.x; x++) {
            for (int y = start.y; y <= end.y; y++) {
                oneCnt += arr[x][y];
            }
        }

        if (oneCnt == 0) {
            zero++;
        } else if(oneCnt == size * size) {
            one++;
        } else {
            dfs(arr, start, end.collapseAll(size / 2), size / 2);
            dfs(arr, start.expandAll(size / 2), end, size / 2);
            dfs(arr, start.expandY(size / 2), end.collapseX(size / 2), size / 2);
            dfs(arr, start.expandX(size / 2), end.collapseY(size / 2), size / 2);
        }
    }
}
