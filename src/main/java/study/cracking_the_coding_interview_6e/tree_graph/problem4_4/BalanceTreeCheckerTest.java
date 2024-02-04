package study.cracking_the_coding_interview_6e.tree_graph.problem4_4;

import study.cracking_the_coding_interview_6e.tree_graph.BinaryNode;
import study.cracking_the_coding_interview_6e.tree_graph.problem4_2.BinarySearchTreeGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BalanceTreeCheckerTest {

    @Test
    @DisplayName("균형 잡힌 이진 트리")
    public void test1() {
        //given
        int[] arr = {1, 3, 5, 7, 9, 10, 16};
        BinaryNode root = BinarySearchTreeGenerator.createMinHeightBinarySearchTree(arr, 0, arr.length - 1);

        //when & then
        assertThat(BalanceTreeChecker.myCheck(root).isBalanced).isTrue();
        assertThat(BalanceTreeChecker.bookCheck(root).isBalanced).isTrue();
    }

    @Test
    @DisplayName("균형 잡히지 않은 이진 트리")
    public void test2() {
        //given
        BinaryNode n1 = new BinaryNode(1);
        BinaryNode n2 = new BinaryNode(2);
        BinaryNode n3 = new BinaryNode(3);
        n1.setRightChild(n2);
        n2.setRightChild(n3);

        //when & then
        assertThat(BalanceTreeChecker.myCheck(n1).isBalanced).isFalse();
        assertThat(BalanceTreeChecker.bookCheck(n1).isBalanced).isFalse();
    }

    @Test
    @DisplayName("균형 잡히지 않은 이진 트리")
    public void test3() {
        //given
        BinaryNode[] binaryNodes = new BinaryNode[9];
        for (int i = 1; i < binaryNodes.length; i++) {
            binaryNodes[i] = new BinaryNode(i);
        }
        binaryNodes[1].setLeftChild(binaryNodes[2]);
        binaryNodes[1].setRightChild(binaryNodes[3]);
        binaryNodes[2].setLeftChild(binaryNodes[4]);
        binaryNodes[2].setRightChild(binaryNodes[5]);
        binaryNodes[3].setRightChild(binaryNodes[6]);
        binaryNodes[4].setLeftChild(binaryNodes[7]);
        binaryNodes[6].setRightChild(binaryNodes[8]);

        //when & then
        assertThat(BalanceTreeChecker.myCheck(binaryNodes[1]).isBalanced).isFalse();
        assertThat(BalanceTreeChecker.bookCheck(binaryNodes[1]).isBalanced).isFalse();
    }

}
