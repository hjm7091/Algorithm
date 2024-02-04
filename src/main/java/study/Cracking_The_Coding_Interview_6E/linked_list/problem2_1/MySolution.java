package study.cracking_the_coding_interview_6e.linked_list.problem2_1;

import study.cracking_the_coding_interview_6e.linked_list.Node;

import java.util.*;

public class MySolution {

    public static <T> void removeDuplication(Node<T> node) {
        Set<T> set = new HashSet<>();
        Node<T> prev = null;
        while (node != null) {
            if (set.contains(node.getData())) {
                prev.setNext(node.getNext());
            } else {
                set.add(node.getData());
                prev = node;
            }
            node = node.getNext();
        }
    }

}
