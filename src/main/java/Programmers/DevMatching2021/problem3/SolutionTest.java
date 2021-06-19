package Programmers.DevMatching2021.problem3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        Solution s = new Solution();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] expected = {360, 958, 108, 0, 450, 18, 180, 1080};

        assertThat(s.solution(enroll, referral, seller, amount)).isEqualTo(expected);
    }

    @Test
    public void case2() {
        Solution s = new Solution();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};
        int[] expected = {0, 110, 378, 180, 270, 450, 0, 0};

        assertThat(s.solution(enroll, referral, seller, amount)).isEqualTo(expected);
    }

}
