package study.cracking_the_coding_interview_6e.linked_list.problem2_8;

import study.cracking_the_coding_interview_6e.linked_list.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BookSolutionTest {

    @Test
    @DisplayName("사이클이 있는 경우")
    public void case1() {
        //given
        Node<Character> node = Node.initOneWay(Arrays.asList('A', 'B', 'C', 'D', 'E'));
        node.getTail().setNext(node.getNthNode(2));

        //when
        Node<Character> beginning = BookSolution.findBeginning(node);

        //then
        assertThat(beginning).isNotNull();
        assertThat(beginning.getData()).isEqualTo('C');
    }

    @Test
    @DisplayName("사이클이 없는 경우")
    public void case2() {
        //given
        Node<Character> node = Node.initOneWay(Arrays.asList('A', 'B', 'C', 'D', 'E'));

        //when
        Node<Character> beginning = BookSolution.findBeginning(node);

        //then
        assertThat(beginning).isNull();
    }

}
