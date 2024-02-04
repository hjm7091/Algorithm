package programmers.dev_matching2021.problem2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void case1() {
        int rows = 6, columns = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
        int[] expected = {8, 10, 25};
        int[] actual = s.solution(rows, columns, queries);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case2() {
        int rows = 3, columns = 3;
        int[][] queries = {{1,1,2,2}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}};
        int[] expected = {1, 1, 5, 3};
        int[] actual = s.solution(rows, columns, queries);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case3() {
        int rows = 100, columns = 97;
        int[][] queries = {{1,1,100,97}};
        int[] expected = {1};
        int[] actual = s.solution(rows, columns, queries);
        assertThat(actual).isEqualTo(expected);
    }

}
