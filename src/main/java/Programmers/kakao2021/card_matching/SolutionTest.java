package Programmers.kakao2021.card_matching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void case1() {
        int[][] board = {{1,0,0,3}, {2,0,0,0}, {0,0,0,2}, {3,0,1,0}};
        int r = 1, c = 0;
        int expected = 14;
        int actual = s.solution(board, r, c);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case2() {
        int[][] board = {{3,0,0,2}, {0,0,1,0}, {0,1,0,0}, {2,0,0,3}};
        int r = 0, c = 1;
        int expected = 16;
        int actual = s.solution(board, r, c);
        assertThat(actual).isEqualTo(expected);
    }

}
