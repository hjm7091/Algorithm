package study.cracking_the_coding_interview_6e.tree_graph.problem4_5;

import study.cracking_the_coding_interview_6e.tree_graph.BinaryNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BSTCheckerTest {

    @Test
    @DisplayName("root가 null인 경우")
    public void case1() {
        assertThat(BSTChecker.getBSTInfo(null).isBST).isFalse();
        assertThat(BSTChecker.checkBST(null)).isTrue();
    }

    @Test
    @DisplayName("자식 노드가 없는 경우")
    public void case2() {
        //given
        BinaryNode root = new BinaryNode(1);

        //when & then
        assertThat(BSTChecker.getBSTInfo(root).isBST).isTrue();
        assertThat(BSTChecker.checkBST(root)).isTrue();
    }

    @Test
    @DisplayName("왼쪽 자식이 BST가 아닌 경우")
    public void case3() {
        //given
        BinaryNode root = new BinaryNode(5);
        BinaryNode l = new BinaryNode(3);
        l.setLeftChild(new BinaryNode(1));
        l.setRightChild(new BinaryNode(2));
        root.setLeftChild(l);

        //when & then
        assertThat(BSTChecker.getBSTInfo(root).isBST).isFalse();
        assertThat(BSTChecker.checkBST(root)).isFalse();
    }

    @Test
    @DisplayName("왼쪽 자식은 BST이고 왼쪽 자식의 가장 큰 값이 root값보다 큰 경우")
    public void case4() {
        //given
        BinaryNode root = new BinaryNode(5);
        BinaryNode l = new BinaryNode(3);
        l.setLeftChild(new BinaryNode(1));
        l.setRightChild(new BinaryNode(6));
        root.setLeftChild(l);

        //when & then
        assertThat(BSTChecker.getBSTInfo(root).isBST).isFalse();
        assertThat(BSTChecker.checkBST(root)).isFalse();
    }

    @Test
    @DisplayName("왼쪽 자식은 BST이고 왼쪽 자식의 가장 큰 값이 root값보다 작은 경우")
    public void case5() {
        //given
        BinaryNode root = new BinaryNode(5);
        BinaryNode l = new BinaryNode(3);
        l.setLeftChild(new BinaryNode(1));
        l.setRightChild(new BinaryNode(4));
        root.setLeftChild(l);

        //when & then
        assertThat(BSTChecker.getBSTInfo(root).isBST).isTrue();
        assertThat(BSTChecker.checkBST(root)).isTrue();
    }

    @Test
    @DisplayName("오른쪽 자식이 BST가 아닌 경우")
    public void case6() {
        //given
        BinaryNode root = new BinaryNode(5);
        BinaryNode r = new BinaryNode(7);
        r.setLeftChild(new BinaryNode(3));
        r.setRightChild(new BinaryNode(1));
        root.setRightChild(r);

        //when & then
        assertThat(BSTChecker.getBSTInfo(root).isBST).isFalse();
        assertThat(BSTChecker.checkBST(root)).isFalse();
    }

    @Test
    @DisplayName("오른쪽 자식은 BST이고 오른쪽 자식의 가장 작은 값이 root값보다 작은 경우")
    public void case7() {
        //given
        BinaryNode root = new BinaryNode(5);
        BinaryNode r = new BinaryNode(7);
        r.setLeftChild(new BinaryNode(1));
        r.setRightChild(new BinaryNode(9));
        root.setRightChild(r);

        //when & then
        assertThat(BSTChecker.getBSTInfo(root).isBST).isFalse();
        assertThat(BSTChecker.checkBST(root)).isFalse();
    }

    @Test
    @DisplayName("오른쪽 자식은 BST이고 오른쪽 자식의 가장 작은 값이 root값보다 큰 경우")
    public void case8() {
        //given
        BinaryNode root = new BinaryNode(5);
        BinaryNode r = new BinaryNode(7);
        r.setLeftChild(new BinaryNode(6));
        r.setRightChild(new BinaryNode(9));
        root.setRightChild(r);

        //when & then
        assertThat(BSTChecker.getBSTInfo(root).isBST).isTrue();
        assertThat(BSTChecker.checkBST(root)).isTrue();
    }

    @Test
    @DisplayName("BST인 경우")
    public void case9() {
        //given
        BinaryNode ll = new BinaryNode(5);
        ll.setLeftChild(new BinaryNode(3));
        ll.setRightChild(new BinaryNode(7));
        BinaryNode lr = new BinaryNode(15);
        lr.setRightChild(new BinaryNode(17));
        BinaryNode l = new BinaryNode(10);
        l.setLeftChild(ll);
        l.setRightChild(lr);
        BinaryNode root = new BinaryNode(20);
        root.setLeftChild(l);
        root.setRightChild(new BinaryNode(30));

        //when & then
        assertThat(BSTChecker.getBSTInfo(root).isBST).isTrue();
        assertThat(BSTChecker.checkBST(root)).isTrue();
    }
}
