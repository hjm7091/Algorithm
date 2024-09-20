package leetcode.medium.restore_ip_addresses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        String s = "25525511135";
        List<String> expected = List.of("255.255.11.135", "255.255.111.35");
        assertThat(solution.restoreIpAddresses(s)).isEqualTo(expected);
    }

    @Test
    void test2() {
        String s = "0000";
        List<String> expected = List.of("0.0.0.0");
        assertThat(solution.restoreIpAddresses(s)).isEqualTo(expected);
    }

    @Test
    void test3() {
        String s = "101023";
        List<String> expected = List.of("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3");
        assertThat(solution.restoreIpAddresses(s)).isEqualTo(expected);
    }

}
