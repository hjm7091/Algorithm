package study.cracking_the_coding_interview_6e.linked_list.problem2_4;

import study.cracking_the_coding_interview_6e.linked_list.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BookSolutionTest {

    @Test
    public void case1() {
        //given
        Node<Integer> node = Node.initOneWay(Arrays.asList(3, 5, 8, 5, 10, 2, 1));
        Node<Integer> expected = Node.initOneWay(Arrays.asList(3, 2, 1, 5, 8, 5, 10));

        //when
        Node<Integer> partition = BookSolution.partition(node, 5);

        //then
        assertThat(partition).isEqualTo(expected);
    }

}
