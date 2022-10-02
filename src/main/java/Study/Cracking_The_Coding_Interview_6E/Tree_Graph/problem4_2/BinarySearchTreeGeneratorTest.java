package Study.Cracking_The_Coding_Interview_6E.Tree_Graph.problem4_2;

import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.BinaryNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeGeneratorTest {

    @Test
    @DisplayName("이진 탐색 트리 생성 확인(length = 1)")
    public void test1() {
        //given
        int[] arr = {1};

        //when
        BinaryNode root = BinarySearchTreeGenerator.createMinHeightBinarySearchTree(arr, 0, 0);

        //then
        BinaryNode.traversal(root);
        assertThat(root).isNotNull();
        assertThat(root.getLeftChild()).isNull();
        assertThat(root.getRightChild()).isNull();
    }

    @Test
    @DisplayName("이진 탐색 트리 생성 확인(length = 2)")
    public void test2() {
        //given
        int[] arr = {1, 3};

        //when
        BinaryNode root = BinarySearchTreeGenerator.createMinHeightBinarySearchTree(arr, 0, arr.length - 1);

        //then
        BinaryNode.traversal(root);
        assertThat(root).isNotNull();
        assertThat(root.getLeftChild()).isNull();
        assertThat(root.getRightChild()).isNotNull();
    }

    @Test
    @DisplayName("이진 탐색 트리 생성 확인(length = 3)")
    public void test3() {
        //given
        int[] arr = {1, 3, 5};

        //when
        BinaryNode root = BinarySearchTreeGenerator.createMinHeightBinarySearchTree(arr, 0, arr.length - 1);

        //then
        BinaryNode.traversal(root);
        assertThat(root).isNotNull();
        assertThat(root.getLeftChild()).isNotNull();
        assertThat(root.getRightChild()).isNotNull();
    }

    @Test
    @DisplayName("이진 탐색 트리 생성 확인(length = 4)")
    public void test4() {
        //given
        int[] arr = {1, 3, 5, 7};

        //when
        BinaryNode root = BinarySearchTreeGenerator.createMinHeightBinarySearchTree(arr, 0, arr.length - 1);

        //then
        BinaryNode.traversal(root);
        assertThat(root).isNotNull();
        assertThat(root.getLeftChild()).isNotNull();
        assertThat(root.getRightChild()).isNotNull();
    }

    @Test
    @DisplayName("이진 탐색 트리 생성 확인(length = 5)")
    public void test5() {
        //given
        int[] arr = {1, 3, 5, 7, 9};

        //when
        BinaryNode root = BinarySearchTreeGenerator.createMinHeightBinarySearchTree(arr, 0, arr.length - 1);

        //then
        BinaryNode.traversal(root);
        assertThat(root).isNotNull();
        assertThat(root.getLeftChild()).isNotNull();
        assertThat(root.getRightChild()).isNotNull();
    }

    @Test
    @DisplayName("이진 탐색 트리 생성 확인(length = 6)")
    public void test6() {
        //given
        int[] arr = {1, 3, 5, 7, 9, 10};

        //when
        BinaryNode root = BinarySearchTreeGenerator.createMinHeightBinarySearchTree(arr, 0, arr.length - 1);

        //then
        BinaryNode.traversal(root);
        assertThat(root).isNotNull();
        assertThat(root.getLeftChild()).isNotNull();
        assertThat(root.getRightChild()).isNotNull();
    }

    @Test
    @DisplayName("이진 탐색 트리 생성 확인(length = 7)")
    public void test7() {
        //given
        int[] arr = {1, 3, 5, 7, 9, 10, 16};

        //when
        BinaryNode root = BinarySearchTreeGenerator.createMinHeightBinarySearchTree(arr, 0, arr.length - 1);

        //then
        BinaryNode.traversal(root);
        assertThat(root).isNotNull();
        assertThat(root.getLeftChild()).isNotNull();
        assertThat(root.getRightChild()).isNotNull();
    }

}
