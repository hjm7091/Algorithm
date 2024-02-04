package study.cracking_the_coding_interview_6e.tree_graph.problem4_2;

import study.cracking_the_coding_interview_6e.tree_graph.BinaryNode;

public class BinarySearchTreeGenerator {

    public static BinaryNode createMinHeightBinarySearchTree(int[] arr, int start, int end) {
        if (start > end) return null;

        int midIdx = (start + end) / 2;
        BinaryNode root = new BinaryNode(arr[midIdx]);
        root.setLeftChild(createMinHeightBinarySearchTree(arr, start, midIdx - 1));
        root.setRightChild(createMinHeightBinarySearchTree(arr, midIdx + 1, end));
        return root;
    }

}
