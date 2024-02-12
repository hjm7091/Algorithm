package study.cracking_the_coding_interview_6e.linked_list.problem2_6;

import study.cracking_the_coding_interview_6e.linked_list.Node;

import java.util.Stack;

public class BookSolution2 {

    public static <T> boolean isPalindrome(Node<T> node) {
        Node<T> fast = node, slow = node;
        Stack<T> stack = new Stack<>();

        while (fast != null && fast.getNext() != null) {
            stack.push(slow.getData());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if (fast != null) slow = slow.getNext();

        while (slow != null) {
            T data = stack.pop();
            if (!slow.getData().equals(data)) return false;
            slow = slow.getNext();
        }

        return true;
    }

}
