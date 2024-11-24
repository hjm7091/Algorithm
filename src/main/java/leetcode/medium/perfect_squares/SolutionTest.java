package leetcode.medium.perfect_squares;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        int n = 12;
        int expected = 3;
        assertThat(solution.numSquares(n)).isEqualTo(expected);
    }

    @Test
    void test2() {
        int n = 13;
        int expected = 2;
        assertThat(solution.numSquares(n)).isEqualTo(expected);
    }

}
