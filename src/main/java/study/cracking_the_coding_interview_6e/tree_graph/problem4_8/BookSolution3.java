package study.cracking_the_coding_interview_6e.tree_graph.problem4_8;

import study.cracking_the_coding_interview_6e.tree_graph.BinaryNode;

public class BookSolution3 {

    public static BinaryNode commonAncestor(BinaryNode root, BinaryNode p, BinaryNode q) {
        if (!covers(root, p) || !covers(root, q)) return null;
        return helper(root, p, q);
    }

    private static BinaryNode helper(BinaryNode root, BinaryNode p, BinaryNode q) {
        if (root == null || root == p || root == q) return root;
        boolean pIsOnLeft = covers(root.getLeftChild(), p);
        boolean qIsOnLeft = covers(root.getLeftChild(), q);
        if (pIsOnLeft != qIsOnLeft) return root;
        BinaryNode childSide = pIsOnLeft ? root.getLeftChild() : root.getRightChild();
        return helper(childSide, p, q);
    }

    private static boolean covers(BinaryNode root, BinaryNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.getLeftChild(), p) || covers(root.getRightChild(), p);
    }

}
