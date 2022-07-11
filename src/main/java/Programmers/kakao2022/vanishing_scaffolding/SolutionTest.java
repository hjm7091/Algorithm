package Programmers.kakao2022.vanishing_scaffolding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void case1() {
        int[][] board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[] aloc = {1, 0}, bloc = {1, 2};
        int expected = 5;
        int actual = this.solution.solution(board, aloc, bloc);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case2() {
        int[][] board = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[] aloc = {1, 0}, bloc = {1, 2};
        int expected = 4;
        int actual = this.solution.solution(board, aloc, bloc);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case3() {
        int[][] board = {{1, 1, 1, 1, 1}};
        int[] aloc = {0, 0}, bloc = {0, 4};
        int expected = 4;
        int actual = this.solution.solution(board, aloc, bloc);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case4() {
        int[][] board = {{1}};
        int[] aloc = {0, 0}, bloc = {0, 0};
        int expected = 0;
        int actual = this.solution.solution(board, aloc, bloc);
        assertThat(actual).isEqualTo(expected);
    }

}
