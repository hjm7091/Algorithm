package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_6;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;

public class BookSolution1 {

    public static <T> boolean isPalindrome(Node<T> node) {
        return isEqual(node, reverseAndClone(node));
    }

    private static <T> Node<T> reverseAndClone(Node<T> node) {
        Node<T> head = null;
        while (node != null) {
            Node<T> n = new Node<>(node.getData());
            n.setNext(head);
            head = n;
            node = node.getNext();
        }
        return head;
    }

    private static <T> boolean isEqual(Node<T> one, Node<T> two) {
        while (one != null && two != null) {
            if (!one.getData().equals(two.getData())) return false;
            one = one.getNext();
            two = two.getNext();
        }
        return one == null && two == null;
    }
}
