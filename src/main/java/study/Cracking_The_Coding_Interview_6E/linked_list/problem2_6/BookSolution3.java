package study.cracking_the_coding_interview_6e.linked_list.problem2_6;

import study.cracking_the_coding_interview_6e.linked_list.Node;

public class BookSolution3 {

    public static <T> boolean isPalindrome(Node<T> node) {
        return isPalindromeRecurse(node, node.size()).result;
    }

    private static <T> Result<T> isPalindromeRecurse(Node<T> head, int length) {
        if (head == null || length <= 0) {
            return new Result<>(head, true);
        } else if (length == 1) {
            return new Result<>(head.getNext(), true);
        }

        Result<T> res = isPalindromeRecurse(head.getNext(), length - 2);

        if (!res.result || res.node == null) return res;

        res.result = head.getData().equals(res.node.getData());

        res.node = res.node.getNext();

        return res;
    }

    private static class Result<T> {
        Node<T> node;
        boolean result;

        public Result(Node<T> node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

}
