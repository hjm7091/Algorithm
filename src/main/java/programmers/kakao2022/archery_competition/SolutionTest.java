package programmers.kakao2022.archery_competition;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void case1() {
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] expected = {0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0};
        int[] actual = this.solution.solution(n, info);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case2() {
        int n = 1;
        int[] info = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] expected = {-1};
        int[] actual = this.solution.solution(n, info);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case3() {
        int n = 9;
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        int[] expected = {1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0};
        int[] actual = this.solution.solution(n, info);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case4() {
        int n = 10;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] expected = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2};
        int[] actual = this.solution.solution(n, info);
        assertThat(actual).isEqualTo(expected);
    }
}
