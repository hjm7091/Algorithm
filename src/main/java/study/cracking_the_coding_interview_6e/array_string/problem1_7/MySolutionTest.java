package study.cracking_the_coding_interview_6e.array_string.problem1_7;

import study.cracking_the_coding_interview_6e.array_string.problem1_7.MySolution.Point;
import study.cracking_the_coding_interview_6e.array_string.problem1_7.MySolution.Range;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MySolutionTest {

    MySolution solution = new MySolution();

    @Test
    public void clock_90_size1() {
        int[][] image = {{0}};
        int[][] expected = {{0}};
        Point start = new Point(0, 0, image);
        Point end = new Point(0, 0, image);

        solution.rotate(image, new Range(start, end), image.length, true);

        assertThat(image).isEqualTo(expected);
    }

    @Test
    public void clock_90_size2() {
        int[][] image = {
            {0, 1},
            {2, 3}
        };
        int[][] expected = {
            {2, 0},
            {3, 1}
        };
        Point start = new Point(0, 0, image);
        Point end = new Point(image.length - 1, image.length - 1, image);

        solution.rotate(image, new Range(start, end), image.length, true);

        assertThat(image).isEqualTo(expected);
    }

    @Test
    public void nonClock_90_size2() {
        int[][] image = {
            {0, 1},
            {2, 3}
        };
        int[][] expected = {
            {1, 3},
            {0, 2}
        };
        Point start = new Point(0, 0, image);
        Point end = new Point(image.length - 1, image.length - 1, image);

        solution.rotate(image, new Range(start, end), image.length, false);

        assertThat(image).isEqualTo(expected);
    }

    @Test
    public void clock_90_size3() {
        int[][] image = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}
        };
        int[][] expected = {
            {6, 3, 0},
            {7, 4, 1},
            {8, 5, 2}
        };
        Point start = new Point(0, 0, image);
        Point end = new Point(image.length - 1, image.length - 1, image);

        solution.rotate(image, new Range(start, end), image.length, true);

        assertThat(image).isEqualTo(expected);
    }

    @Test
    public void nonClock_90_size3() {
        int[][] image = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}
        };
        int[][] expected = {
            {2, 5, 8},
            {1, 4, 7},
            {0, 3, 6}
        };
        Point start = new Point(0, 0, image);
        Point end = new Point(image.length - 1, image.length - 1, image);

        solution.rotate(image, new Range(start, end), image.length, false);

        assertThat(image).isEqualTo(expected);
    }

    @Test
    public void clock_90_size4() {
        int[][] image = {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}
        };
        int[][] expected = {
            {12, 8, 4, 0},
            {13, 9, 5, 1},
            {14, 10, 6, 2},
            {15, 11, 7, 3}
        };
        Point start = new Point(0, 0, image);
        Point end = new Point(image.length - 1, image.length - 1, image);

        solution.rotate(image, new Range(start, end), image.length, true);

        assertThat(image).isEqualTo(expected);
    }

    @Test
    public void nonClock_90_size4() {
        int[][] image = {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}
        };
        int[][] expected = {
            {3, 7, 11, 15},
            {2, 6, 10, 14},
            {1, 5, 9, 13},
            {0, 4, 8, 12}
        };
        Point start = new Point(0, 0, image);
        Point end = new Point(image.length - 1, image.length - 1, image);

        solution.rotate(image, new Range(start, end), image.length, false);

        assertThat(image).isEqualTo(expected);
    }
}
