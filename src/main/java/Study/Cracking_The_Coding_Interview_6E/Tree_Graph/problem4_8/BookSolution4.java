package Study.Cracking_The_Coding_Interview_6E.Tree_Graph.problem4_8;

import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.BinaryNode;

public class BookSolution4 {

    public static BinaryNode commonAncestor(BinaryNode root, BinaryNode p, BinaryNode q) {
        Result r = helper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }

    private static Result helper(BinaryNode root, BinaryNode p, BinaryNode q) {
        if (root == null) return new Result(null, false);

        if (root == p && root == q) return new Result(root, true);

        Result rx = helper(root.getLeftChild(), p, q);
        if (rx.isAncestor) return rx;

        Result ry = helper(root.getRightChild(), p, q);
        if (ry.isAncestor) return ry;

        if (rx.node != null && ry.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    private static class Result {
        public BinaryNode node;
        public boolean isAncestor;
        public Result(BinaryNode node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }

}
