package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_5;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MySolutionTest {

    @Test
    @DisplayName("예제 테스트(예제 입출력)")
    public void case1() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(7, 1, 6));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(5, 9, 2));
        Node<Integer> expected = Node.initOneWay(Arrays.asList(2, 1, 9));

        //when
        Node<Integer> sum = MySolution.sumTwoListReversedWay(node1, node2);

        //then
        assertThat(sum).isEqualTo(expected);
    }

    @Test
    @DisplayName("예제 테스트(길이가 다른 경우)")
    public void case2() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(7, 1, 6, 1));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(5, 9, 2));
        Node<Integer> expected = Node.initOneWay(Arrays.asList(2, 1, 9, 1));

        //when
        Node<Integer> sum = MySolution.sumTwoListReversedWay(node1, node2);

        //then
        assertThat(sum).isEqualTo(expected);
    }

    @Test
    @DisplayName("예제 테스트(마지막에 올림 수가 있는 경우)")
    public void case3() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(9, 7, 8));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(6, 8, 5));
        Node<Integer> expected = Node.initOneWay(Arrays.asList(5, 6, 4, 1));

        //when
        Node<Integer> sum = MySolution.sumTwoListReversedWay(node1, node2);

        //then
        assertThat(sum).isEqualTo(expected);
    }

    @Test
    @DisplayName("연관 문제 테스트(예제 입출력)")
    public void case4() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(6, 1, 7));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(2, 9, 5));
        Node<Integer> expected = Node.initOneWay(Arrays.asList(9, 1, 2));

        //when
        Node<Integer> sum = MySolution.sumTwoListNormalWay(node1, node2);

        //then
        assertThat(sum).isEqualTo(expected);
    }

    @Test
    @DisplayName("연관 문제 테스트(길이가 다른 경우1)")
    public void case5() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(6, 1, 7, 1));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(3, 9, 2));
        Node<Integer> expected = Node.initOneWay(Arrays.asList(6, 5, 6, 3));

        //when
        Node<Integer> sum = MySolution.sumTwoListNormalWay(node1, node2);

        //then
        assertThat(sum).isEqualTo(expected);
    }

    @Test
    @DisplayName("연관 문제 테스트(길이가 다른 경우2)")
    public void case6() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(1, 2, 3, 4));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(5, 6, 7));
        Node<Integer> expected = Node.initOneWay(Arrays.asList(1, 8, 0, 1));

        //when
        Node<Integer> sum = MySolution.sumTwoListNormalWay(node1, node2);

        //then
        assertThat(sum).isEqualTo(expected);
    }

}
