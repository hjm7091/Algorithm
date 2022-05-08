package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_8;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;

public class BookSolution {

    public static <T> Node<T> findBeginning(Node<T> head) {
        Node<T> slow = head, fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) break;
        }

        if (fast == null || fast.getNext() == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return fast;
    }

}
