package leetcode.medium.sum_root_to_leaf_numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int expected = 25;
        assertThat(solution.sumNumbers(root)).isEqualTo(expected);
    }

    @Test
    void test2() {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(9);
        root.left = left;
        root.right = new TreeNode(0);
        left.left = new TreeNode(5);
        left.right = new TreeNode(1);
        int expected = 1026;
        assertThat(solution.sumNumbers(root)).isEqualTo(expected);
    }

}
