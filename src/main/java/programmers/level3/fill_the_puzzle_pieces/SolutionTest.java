package programmers.level3.fill_the_puzzle_pieces;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void case1() {
        int[][] game_board = {
            {1,1,0,0,1,0},
            {0,0,1,0,1,0},
            {0,1,1,0,0,1},
            {1,1,0,1,1,1},
            {1,0,0,0,1,0},
            {0,1,1,1,0,0}
        };
        int[][] table = {
            {1,0,0,1,1,0},
            {1,0,1,0,1,0},
            {0,1,1,0,1,1},
            {0,0,1,0,0,0},
            {1,1,0,1,1,0},
            {0,1,0,0,0,0}
        };
        int expected = 14;
        int actual = this.solution.solution(game_board, table);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case2() {
        int[][] game_board = {
            {0,0,0},
            {1,1,0},
            {1,1,1}
        };
        int[][] table = {
            {1,1,1},
            {1,0,0},
            {0,0,0}
        };
        int expected = 0;
        int actual = this.solution.solution(game_board, table);
        assertThat(actual).isEqualTo(expected);
    }
}
