package study.cracking_the_coding_interview_6e.array_string.problem1_8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MySolutionTest {

    MySolution solution = new MySolution();

    @Test
    public void case1() {
        int[][] arr = {
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1},
        };
        int[][] expected = {
            {1, 1, 0, 1, 1},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
        };
        solution.setZeros(arr);

        assertThat(arr).isEqualTo(expected);
    }

    @Test
    public void case2() {
        int[][] arr = {
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 1, 1},
        };
        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        solution.setZeros(arr);

        assertThat(arr).isEqualTo(expected);
    }

}
