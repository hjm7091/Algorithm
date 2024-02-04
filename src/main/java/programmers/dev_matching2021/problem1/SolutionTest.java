package programmers.dev_matching2021.problem1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void case1() {
        //given
        int[] lottos = {44, 1, 0, 0, 31, 25}, win_nums = {31, 10, 45, 1, 6, 19};
        int[] expected = {3, 5};

        //when
        int[] actual = this.solution.solution(lottos, win_nums);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case2() {
        //given
        int[] lottos = {0, 0, 0, 0, 0, 0}, win_nums = {38, 19, 20, 40, 15, 25};
        int[] expected = {1, 6};

        //when
        int[] actual = this.solution.solution(lottos, win_nums);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case3() {
        //given
        int[] lottos = {45, 4, 35, 20, 3, 9}, win_nums = {20, 9, 3, 45, 4, 35};
        int[] expected = {1, 1};

        //when
        int[] actual = this.solution.solution(lottos, win_nums);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
