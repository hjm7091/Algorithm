package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_5;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;

public class BookSolution {

    public static Node<Integer> addNodesReversedWay(Node<Integer> n1, Node<Integer> n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) return null;

        int value = carry;
        if (n1 != null) value += n1.getData();
        if (n2 != null) value += n2.getData();
        Node<Integer> node = new Node<>(value % 10);

        if (n1 != null || n2 != null) {
            Node<Integer> next = addNodesReversedWay(n1 == null ? null : n1.getNext(),
                                          n2 == null ? null : n2.getNext(),
                                          value >= 10 ? 1 : 0);
            node.setNext(next);
        }

        return node;
    }

    public static Node<Integer> addNodesNormalWay(Node<Integer> n1, Node<Integer> n2) {
        int len1 = n1.size(), len2 = n2.size();
        if (len1 < len2) n1 = padNode(n1, len2 - len1);
        else n2 = padNode(n2, len1 - len2);

        PartialSum sum = addNodeHelper(n1, n2);
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            return insertBefore(sum.sum, sum.carry);
        }
    }

    private static PartialSum addNodeHelper(Node<Integer> n1, Node<Integer> n2) {
        if (n1 == null) return new PartialSum();
        PartialSum sum = addNodeHelper(n1.getNext(), n2.getNext());
        int val = sum.carry + n1.getData() + n2.getData();
        sum.sum = insertBefore(sum.sum, val % 10);
        sum.carry = val / 10;
        return sum;
    }

    private static Node<Integer> padNode(Node<Integer> n, int paddingCount) {
        Node<Integer> head = n;
        for (int i = 0; i < paddingCount; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private static Node<Integer> insertBefore(Node<Integer> n, int data) {
        Node<Integer> node = new Node<>(data);
        if (n != null) node.setNext(n);
        return node;
    }

    private static class PartialSum {
        Node<Integer> sum = null;
        int carry = 0;
    }

}
