package Study.Cracking_The_Coding_Interview_6E.Tree_Graph.problem4_6;

import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.BinaryNode;
import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.PointingParentNode;

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
