package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_6;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;

import java.util.Objects;

public class MySolution {

    public static <T> boolean isPalindrome(Node<T> node) {
        return Objects.requireNonNull(node).copy().reverse().equals(node);
    }

}
