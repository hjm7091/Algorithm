package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_2;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;

public class BookSolution {

    public static <T> Node<T> kthToLast(Node<T> head, int k) {
        return kthToLast(head, k, new Index());
    }

    private static <T> Node<T> kthToLast(Node<T> head, int k, Index index) {
        if (head == null) return null;
        Node<T> node = kthToLast(head.getNext(), k, index);
        index.plus(1);
        if (index.value == k) return head;
        return node;
    }

    private static class Index {
        public int value = 0;
        public void plus(int value) {
            this.value += value;
        }
    }

    public static <T> Node<T> nthToLast(Node<T> head, int k) {
        Node<T> p1 = head, p2 = head;

        for (int i = 0; i < k; i++) {
            p2 = p2.getNext();
        }

        while (p2 != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p1;
    }

}
