package Study.Cracking_The_Coding_Interview_6E.Tree_Graph;

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
