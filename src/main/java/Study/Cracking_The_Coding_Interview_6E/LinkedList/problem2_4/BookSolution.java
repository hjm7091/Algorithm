package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_4;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;

public class BookSolution {

    public static Node<Integer> partition(Node<Integer> node, int x) {
        Node<Integer> beforeStart = null;
        Node<Integer> beforeEnd = null;
        Node<Integer> afterStart = null;
        Node<Integer> afterEnd = null;

        while (node != null) {
            Node<Integer> next = node.getNext();
            node.setNext(null);
            if (node.getData() < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.setNext(node);
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.setNext(node);
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) return afterStart;

        beforeEnd.setNext(afterStart);
        return beforeStart;
    }

}
