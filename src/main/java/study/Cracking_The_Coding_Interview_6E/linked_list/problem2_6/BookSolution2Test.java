package study.cracking_the_coding_interview_6e.linked_list.problem2_6;

import study.cracking_the_coding_interview_6e.linked_list.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BookSolution2Test {

    @Test
    @DisplayName("홀수 테스트")
    public void case1() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(1, 4, 5, 4, 1));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(1, 4, 5, 2, 1));

        //then
        assertThat(BookSolution2.isPalindrome(node1)).isTrue();
        assertThat(BookSolution2.isPalindrome(node2)).isFalse();
    }

    @Test
    @DisplayName("짝수 테스트")
    public void case2() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(1, 4, 5, 5, 4, 1));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(1, 4, 5, 5, 3, 1));

        //then
        assertThat(BookSolution2.isPalindrome(node1)).isTrue();
        assertThat(BookSolution2.isPalindrome(node2)).isFalse();
    }

}
