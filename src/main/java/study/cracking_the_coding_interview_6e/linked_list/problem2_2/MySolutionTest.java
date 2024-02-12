package study.cracking_the_coding_interview_6e.linked_list.problem2_2;

import study.cracking_the_coding_interview_6e.linked_list.Node;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MySolutionTest {

    @Test
    public void case1() {
        //given
        Node<Integer> node = Node.initOneWay(Arrays.asList(1, 2, 3, 4));

        //when
        Node<Integer> findNode1 = MySolution.findElementOfKFromLast(node, 4);
        Node<Integer> findNode2 = MySolution.findElementOfKFromLast(node, 3);
        Node<Integer> findNode3 = MySolution.findElementOfKFromLast(node, 2);
        Node<Integer> findNode4 = MySolution.findElementOfKFromLast(node, 1);

        //then
        assertThat(findNode1.getData()).isEqualTo(1);
        assertThat(findNode2.getData()).isEqualTo(2);
        assertThat(findNode3.getData()).isEqualTo(3);
        assertThat(findNode4.getData()).isEqualTo(4);
    }

    @Test
    public void case2() {
        //given
        Node<Integer> node = Node.initOneWay(Arrays.asList(1, 2, 3, 4));

        //when
        assertThrows(InvalidParameterException.class, () -> MySolution.findElementOfKFromLast(node, 5));
        assertThrows(InvalidParameterException.class, () -> MySolution.findElementOfKFromLast(node, 0));
    }

}
