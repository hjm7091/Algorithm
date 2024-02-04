package programmers.kakao2022.find_decimals_in_k_number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void case1() {
        int n = 437674, k = 3;
        int expected = 3;
        int actual = this.solution.solution(n, k);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case2() {
        int n = 110011, k = 10;
        int expected = 2;
        int actual = this.solution.solution(n, k);
        assertThat(actual).isEqualTo(expected);
    }
}
