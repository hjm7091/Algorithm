package study.cracking_the_coding_interview_6e.linked_list.problem2_7;

import study.cracking_the_coding_interview_6e.linked_list.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BookSolutionTest {

    @Test
    @DisplayName("교집합이 존재하는 경우")
    public void case1() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(3, 1, 5, 9, 7, 2, 1));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(4, 6));
        node2.getTail().setNext(node1.getNthNode(4));

        //when
        Node<Integer> intersection = BookSolution.findIntersection(node1, node2);

        //then
        assertThat(intersection.getDataList()).isEqualTo(Arrays.asList(7, 2, 1));
    }

    @Test
    @DisplayName("교집합이 존재하지 않는 경우")
    public void case2() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(3, 1, 5, 9, 7, 2, 1));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(4, 6));

        //when
        Node<Integer> intersection = BookSolution.findIntersection(node1, node2);

        //then
        assertThat(intersection).isNull();
    }

}
