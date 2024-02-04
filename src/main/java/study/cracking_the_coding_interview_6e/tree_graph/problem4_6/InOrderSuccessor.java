package study.cracking_the_coding_interview_6e.tree_graph.problem4_6;

import study.cracking_the_coding_interview_6e.tree_graph.BinaryNode;
import study.cracking_the_coding_interview_6e.tree_graph.PointingParentNode;

public class InOrderSuccessor {

    public static BinaryNode findNext(PointingParentNode node) {
        if (node == null) return null;
        if (node.getRightChild() != null) return leftMostChild(node.getRightChild());
        PointingParentNode q = node;
        PointingParentNode x = node.getParent();
        while (x != null && x.getLeftChild() != q) {
            q = x;
            x = x.getParent();
        }
        return x;
    }

    private static BinaryNode leftMostChild(BinaryNode node) {
        if (node == null) return null;
        while (node.getLeftChild() != null) node = node.getLeftChild();
        return node;
    }

}
