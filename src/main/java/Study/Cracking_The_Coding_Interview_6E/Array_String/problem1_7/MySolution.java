package Study.Cracking_The_Coding_Interview_6E.Array_String.problem1_7;

import java.security.InvalidParameterException;
import java.util.Objects;

public class MySolution {

    public void rotate(int[][] image, Range range, int size, boolean clockWay) {
        Point start = range.start.copy(image);
        Point end = range.end.copy(image);

        if (size == 1) return;

        Point[] points = buildDirPointsBy(clockWay);

        int cnt = size;
        while (--cnt > 0) {
            int dir = -1;
            Point prevPoint = start.copy(image);
            int count = getMovementCount();

            do {
                dir = getNextDir(dir, points.length);
                Point nextPoint = getNextPoint(prevPoint.copy(image), range, size, dir, points, image);
                Point temp = nextPoint.copy(image);
                image[nextPoint.x][nextPoint.y] = prevPoint.value;
                prevPoint = temp;
            } while (count-- > 0);

            start.nextY(end);
        }

        Point newStart = new Point(range.start.x + 1, range.start.y + 1, image);
        Point newEnd = new Point(range.end.x - 1, range.end.y - 1, image);
        rotate(image, new Range(newStart, newEnd), size / 2, clockWay);
    }

    private int getMovementCountBy(int degree) {
        if (degree % 90 != 0) {
            throw new InvalidParameterException(degree + " degree is not allowed here.");
        }
        return degree / 30;
    }

    private int getMovementCount() {
        return 3;
    }

    private Point getNextPoint(Point point, Range range, int size, int dir, Point[] points, int[][] image) {
        while (--size > 0) {
            point.doMovement(points[dir]);

            if (!range.contains(point)) {
                point.unDoMovement(points[dir]);
                dir = getNextDir(dir, points.length);
                point.doMovement(points[dir]);
            }

        }

        return point.copy(image);
    }

    private int getNextDir(int dir, int size) {
        return ++dir == size ? 0 : dir;
    }

    private Point[] buildDirPointsBy(boolean clockWay) {
        Point[] points = new Point[4];
        if (clockWay) {
            points[0] = new Point(0, 1);
            points[2] = new Point(0, -1);
        } else {
            points[0] = new Point(0, -1);
            points[2] = new Point(0, 1);
        }
        points[1] = new Point(1, 0);
        points[3] = new Point(-1, 0);
        return points;
    }

    static class Point {
        int x, y;
        int value = -1;

        public Point(int x, int y, int[][] image) {
            this.x = x;
            this.y = y;
            this.value = image[x][y];
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point copy(int[][] image) {
            return new Point(this.x, this.y, image);
        }

        public void doMovement(Point p) {
            this.x += p.x;
            this.y += p.y;
        }

        public void unDoMovement(Point p) {
            this.x -= p.x;
            this.y -= p.y;
        }

        public void nextY(Point end) {
            this.y = this.y + 1 > end.y ? 0 : this.y + 1;
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

    static class Range {
        Point start, end;
        public Range(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public boolean contains(Point p) {
            return start.x <= p.x && p.x <= end.x && start.y <= p.y && p.y <= end.y;
        }
    }

}
