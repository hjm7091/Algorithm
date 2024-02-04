package study.cracking_the_coding_interview_6e.tree_graph.problem4_4;

import study.cracking_the_coding_interview_6e.tree_graph.BinaryNode;

public class BalanceTreeChecker {

    public static NodeInfo myCheck(BinaryNode root) {
        if (root == null) return new NodeInfo(0, true);
        NodeInfo lNodeInfo = myCheck(root.getLeftChild());
        NodeInfo rNodeInfo = myCheck(root.getRightChild());
        int maxHeight = Math.max(lNodeInfo.height, rNodeInfo.height);
        int heightDiff = Math.abs(rNodeInfo.height - lNodeInfo.height);
        return new NodeInfo(maxHeight + 1, lNodeInfo.isBalanced && rNodeInfo.isBalanced && heightDiff < 2);
    }

    protected static class NodeInfo {
        int height;
        boolean isBalanced;
        public NodeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static NodeInfo bookCheck(BinaryNode root) {
        int height = checkHeight(root);
        return new NodeInfo(height, height != Integer.MIN_VALUE);
    }

    private static int checkHeight(BinaryNode root) {
        if (root == null) return 0;

        int leftHeight = checkHeight(root.getLeftChild());
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.getRightChild());
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = Math.abs(leftHeight - rightHeight);
        return heightDiff > 1 ? Integer.MIN_VALUE : Math.max(leftHeight, rightHeight) + 1;
    }
}
