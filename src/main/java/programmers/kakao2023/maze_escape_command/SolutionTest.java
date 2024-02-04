package programmers.kakao2023.maze_escape_command;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void case1() {
        int n = 3, m = 4, x = 2, y = 3, r = 3, c = 1, k = 5;
        String expected = "dllrl";
        String actual = this.solution.solution(n, m, x, y, r, c, k);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case2() {
        int n = 2, m = 2, x = 1, y = 1, r = 2, c = 2, k = 2;
        String expected = "dr";
        String actual = this.solution.solution(n, m, x, y, r, c, k);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case3() {
        int n = 3, m = 3, x = 1, y = 2, r = 3, c = 3, k = 4;
        String expected = "impossible";
        String actual = this.solution.solution(n, m, x, y, r, c, k);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void case4() {
        int n = 3, m = 4, x = 2, y = 3, r = 3, c = 1, k = 2500;
        String expected = "impossible";
        String actual = this.solution.solution(n, m, x, y, r, c, k);
        assertThat(actual).isEqualTo(expected);
    }

}
