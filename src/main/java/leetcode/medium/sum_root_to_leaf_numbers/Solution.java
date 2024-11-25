package leetcode.medium.sum_root_to_leaf_numbers;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode curr, int currSum) {
        if (curr == null) return 0;
        int nextSum = currSum * 10 + curr.val;
        if (curr.left == null && curr.right == null) {
            return nextSum;
        }
        return sum(curr.left, nextSum) + sum(curr.right, nextSum);
    }
}
