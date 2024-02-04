package study.cracking_the_coding_interview_6e.linked_list.problem2_2;

import study.cracking_the_coding_interview_6e.linked_list.Node;

import java.security.InvalidParameterException;

public class MySolution {

    public static <T> Node<T> findElementOfKFromLast(Node<T> node, int k) {
        int size = node.size();
        if (k < 1 || k > size) throw new InvalidParameterException();
        int count = size - (k + 1);
        Node<T> p = node;

        while (count-- > 0) {
            p = p.getNext();
        }

        return count < -1 ? p : p.getNext();
    }

}
