package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_2;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BookSolutionTest {

    @Test
    public void way1() {
        //given
        Node<Integer> node = Node.initOneWay(Arrays.asList(1, 2, 3, 4));

        //when
        Node<Integer> findNode1 = BookSolution.kthToLast(node, 4);
        Node<Integer> findNode2 = BookSolution.kthToLast(node, 3);
        Node<Integer> findNode3 = BookSolution.kthToLast(node, 2);
        Node<Integer> findNode4 = BookSolution.kthToLast(node, 1);

        //then
        assertThat(findNode1.getData()).isEqualTo(1);
        assertThat(findNode2.getData()).isEqualTo(2);
        assertThat(findNode3.getData()).isEqualTo(3);
        assertThat(findNode4.getData()).isEqualTo(4);
    }

    @Test
    public void way2() {
        //given
        Node<Integer> node = Node.initOneWay(Arrays.asList(1, 2, 3, 4));

        //when
        Node<Integer> findNode1 = BookSolution.nthToLast(node, 4);
        Node<Integer> findNode2 = BookSolution.nthToLast(node, 3);
        Node<Integer> findNode3 = BookSolution.nthToLast(node, 2);
        Node<Integer> findNode4 = BookSolution.nthToLast(node, 1);

        //then
        assertThat(findNode1.getData()).isEqualTo(1);
        assertThat(findNode2.getData()).isEqualTo(2);
        assertThat(findNode3.getData()).isEqualTo(3);
        assertThat(findNode4.getData()).isEqualTo(4);
    }

}
