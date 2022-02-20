package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_1;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    @Test
    public void case1() {
        //given
        Node<Integer> node = Node.initOneWay(Arrays.asList(1, 2, 3, 4, 1));
        System.out.println("before : " + node);
        assertTrue(node.hasDuplicatedData());

        //when
        MySolution.removeDuplication(node);
        System.out.println("after : " + node);

        //then
        assertFalse(node.hasDuplicatedData());
    }

    @Test
    public void case2() {
        //given
        Node<Integer> node = Node.initOneWay(Arrays.asList(1, 2, 3, 5, 7, 2, 3, 4, 1, 2));
        System.out.println("before : " + node);
        assertTrue(node.hasDuplicatedData());

        //when
        MySolution.removeDuplication(node);
        System.out.println("after : " + node);

        //then
        assertFalse(node.hasDuplicatedData());
    }

    @Test
    public void case3() {
        //given
        Node<Integer> node = Node.initOneWay(Arrays.asList(7, 2, 3, 5, 7, 2, 3, 4, 1, 2));
        System.out.println("before : " + node);
        assertTrue(node.hasDuplicatedData());

        //when
        BookSolution.removeDuplication(node);
        System.out.println("after : " + node);

        //then
        assertFalse(node.hasDuplicatedData());
    }

    @Test
    public void case4() {
        //given
        Node<Integer> node = Node.initOneWay(Collections.singletonList(1));
        System.out.println("before : " + node);

        //when
        MySolution.removeDuplication(node);
        BookSolution.removeDuplication(node);
        System.out.println("after : " + node);

        //then
        assertFalse(node.hasDuplicatedData());
    }

}
