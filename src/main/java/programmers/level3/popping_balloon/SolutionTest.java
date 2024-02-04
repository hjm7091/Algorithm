package programmers.level3.popping_balloon;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{9, -1, -5});
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33});
        assertThat(result).isEqualTo(6);
    }

}
