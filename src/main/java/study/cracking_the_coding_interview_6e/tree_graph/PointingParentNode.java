package study.cracking_the_coding_interview_6e.tree_graph;

public class PointingParentNode extends BinaryNode {

    final PointingParentNode parent;

    public PointingParentNode(int value, PointingParentNode parent) {
        super(value);
        this.parent = parent;
    }

    public PointingParentNode getParent() {
        return parent;
    }
}
