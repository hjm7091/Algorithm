package Study.Cracking_The_Coding_Interview_6E.Array_String.problem1_7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookSolutionTest {

    BookSolution solution = new BookSolution();

    @Test
    public void clock_90_size1() {
        int[][] image = {{0}};
        int[][] expected = {{0}};
        solution.rotate(image);
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
        solution.rotate(image);
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
        solution.rotate(image);
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
        solution.rotate(image);
        assertThat(image).isEqualTo(expected);
    }
}
