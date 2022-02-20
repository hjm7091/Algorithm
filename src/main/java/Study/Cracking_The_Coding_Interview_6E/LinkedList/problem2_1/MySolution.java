package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_1;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;

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
