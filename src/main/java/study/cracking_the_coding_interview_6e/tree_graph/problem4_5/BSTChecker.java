package study.cracking_the_coding_interview_6e.tree_graph.problem4_5;

import study.cracking_the_coding_interview_6e.tree_graph.BinaryNode;

public class BSTChecker {

    public static BSTInfo getBSTInfo(BinaryNode root) {
        if (root == null) return new BSTInfo(false, -1, -1);
        int rootValue = root.getValue();
        BinaryNode leftChild = root.getLeftChild();
        BinaryNode rightChild = root.getRightChild();
        if (leftChild != null && rightChild != null) {
            BSTInfo leftInfo = getBSTInfo(leftChild);
            BSTInfo rightInfo = getBSTInfo(rightChild);
            boolean isBST = (leftInfo.maxValue < rootValue && rootValue < rightInfo.minValue) && leftInfo.isBST && rightInfo.isBST;
            return new BSTInfo(isBST, rightInfo.maxValue, leftInfo.minValue);
        } else if (leftChild != null) {
            BSTInfo leftInfo = getBSTInfo(leftChild);
            return new BSTInfo((leftInfo.maxValue < rootValue) && leftInfo.isBST, rootValue, leftInfo.minValue);
        } else if (rightChild != null) {
            BSTInfo rightInfo = getBSTInfo(rightChild);
            return new BSTInfo((rootValue < rightInfo.minValue) && rightInfo.isBST, rightInfo.maxValue, rootValue);
        }
        return new BSTInfo(true, rootValue, rootValue);
    }

    public static class BSTInfo {
        boolean isBST;
        int maxValue;
        int minValue;
        public BSTInfo(boolean isBST, int maxValue, int minValue) {
            this.isBST = isBST;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }

    public static boolean checkBST(BinaryNode root) {
        return checkBST(root, null, null);
    }

    private static boolean checkBST(BinaryNode root, Integer min, Integer max) {
        if (root == null) return true;
        int rootValue = root.getValue();
        if ((min != null && rootValue <= min) || (max != null && rootValue > max)) return false;
        return checkBST(root.getLeftChild(), min, rootValue) && checkBST(root.getRightChild(), rootValue, max);
    }

}
