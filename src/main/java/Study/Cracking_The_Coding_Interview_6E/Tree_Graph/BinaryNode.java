package Study.Cracking_The_Coding_Interview_6E.Tree_Graph;

public class BinaryNode {

    private final int value;

    private BinaryNode leftChild, rightChild;

    public BinaryNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public BinaryNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        this.rightChild = rightChild;
    }

    public static void traversal(BinaryNode root) {
        if (root == null) return;
        System.out.println(root.toString());
        traversal(root.leftChild);
        traversal(root.rightChild);
    }

    @Override
    public String toString() {
        return String.format("%d <- %d -> %d", leftChild == null ? -1 : leftChild.value, value, rightChild == null ? -1 : rightChild.value);
    }
}
