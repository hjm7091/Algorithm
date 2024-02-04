package study.cracking_the_coding_interview_6e.linked_list.problem2_8;

import study.cracking_the_coding_interview_6e.linked_list.Node;

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
