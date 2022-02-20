package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_1;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;

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
