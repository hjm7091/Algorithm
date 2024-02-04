package study.cracking_the_coding_interview_6e.linked_list.problem2_1;

import study.cracking_the_coding_interview_6e.linked_list.Node;

public class BookSolution {

    public static <T> void removeDuplication(Node<T> node) {
        Node<T> current = node;

        while (current != null) {
            Node<T> runner = current;
            while (runner.getNext() != null) {
                if (runner.getNext().getData() == current.getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }

}
