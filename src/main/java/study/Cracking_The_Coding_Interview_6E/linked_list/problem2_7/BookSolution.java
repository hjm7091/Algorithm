package study.cracking_the_coding_interview_6e.linked_list.problem2_7;

import study.cracking_the_coding_interview_6e.linked_list.Node;

public class BookSolution {

    public static <T> Node<T> findIntersection(Node<T> node1, Node<T> node2) {
        if (node1 == null || node2 == null) return null;

        Result<T> result1 = new Result<>(node1);
        Result<T> result2 = new Result<>(node2);

        if (result1.tail != result2.tail) return null;

        Node<T> shorter = result1.size < result2.size ? node1 : node2;
        Node<T> longer = result1.size < result2.size ? node2 : node1;

        longer = longer.getNthNode(Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.getNext();
            longer = longer.getNext();
        }

        return longer;
    }

    private static class Result<T> {
        Node<T> tail;
        int size;
        public Result(Node<T> node) {
            this.tail = node.getTail();
            this.size = node.size();
        }
    }

}
