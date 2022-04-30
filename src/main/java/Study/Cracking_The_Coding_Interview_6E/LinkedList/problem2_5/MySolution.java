package Study.Cracking_The_Coding_Interview_6E.LinkedList.problem2_5;

import Study.Cracking_The_Coding_Interview_6E.LinkedList.Node;

import java.util.Objects;

public class MySolution {

    public static Node<Integer> sumTwoListReversedWay(Node<Integer> node1, Node<Integer> node2) {
        Objects.requireNonNull(node1);
        Objects.requireNonNull(node2);

        Node<Integer> node = null, pointer = null;
        int share = 0, remainder;
        while (node1 != null || node2 != null) {
            int sum = node1 == null ? node2.getData() : node2 == null ? node1.getData() : node1.getData() + node2.getData();
            sum += share;
            share = sum / 10;
            remainder = sum % 10;

            if (node == null) {
                node = new Node<>(remainder);
                pointer = node;
            } else {
                pointer.setNext(new Node<>(remainder));
                pointer = pointer.getNext();
            }

            if (node1 != null) node1 = node1.getNext();
            if (node2 != null) node2 = node2.getNext();
        }

        if (share != 0) pointer.setNext(new Node<>(share));

        return node;
    }

    public static Node<Integer> sumTwoListNormalWay(Node<Integer> node1, Node<Integer> node2) {
        return sumTwoListReversedWay(Objects.requireNonNull(node1).reverse(), Objects.requireNonNull(node2).reverse()).reverse();
    }

}
