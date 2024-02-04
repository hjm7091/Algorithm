package study.cracking_the_coding_interview_6e.linked_list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class NodeTest {

    @Test
    @DisplayName("length = 1, 값이 같은 경우_같음")
    public void case1() {
        //given
        Node<Integer> node1 = Node.initOneWay(Collections.singletonList(3));
        Node<Integer> node2 = Node.initOneWay(Collections.singletonList(3));

        //then
        assertThat(node1).isEqualTo(node2);
    }

    @Test
    @DisplayName("length = 1, 값이 다른 경우_같지 않음")
    public void case2() {
        //given
        Node<Integer> node1 = Node.initOneWay(Collections.singletonList(1));
        Node<Integer> node2 = Node.initOneWay(Collections.singletonList(2));

        //then
        assertThat(node1).isNotEqualTo(node2);
    }

    @Test
    @DisplayName("length >= 2, 값이 하나라도 다른 경우_같지 않음")
    public void case3() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(1, 2, 3));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(1, 2, 4));

        //then
        assertThat(node1).isNotEqualTo(node2);
    }

    @Test
    @DisplayName("length >= 2, 값이 모두 같은 경우_같음")
    public void case4() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(1, 2, 3));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(1, 2, 3));

        //then
        assertThat(node1).isEqualTo(node2);
    }

    @Test
    @DisplayName("length >= 2, 순서가 다른 경우_같지 않음")
    public void case5() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(1, 2, 3));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(3, 1, 2));

        //then
        assertThat(node1).isNotEqualTo(node2);
    }

    @Test
    @DisplayName("길이가 다른 경우_같지 않음")
    public void case6() {
        //given
        Node<Integer> node1 = Node.initOneWay(Arrays.asList(1, 2));
        Node<Integer> node2 = Node.initOneWay(Arrays.asList(1, 2, 3));

        //then
        assertThat(node1).isNotEqualTo(node2);
    }

}
