package study.cracking_the_coding_interview_6e.linked_list.problem2_6;

import study.cracking_the_coding_interview_6e.linked_list.Node;

import java.util.Objects;

public class MySolution {

    public static <T> boolean isPalindrome(Node<T> node) {
        return Objects.requireNonNull(node).copy().reverse().equals(node);
    }

}
