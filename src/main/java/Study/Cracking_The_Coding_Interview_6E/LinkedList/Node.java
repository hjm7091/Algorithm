package Study.Cracking_The_Coding_Interview_6E.LinkedList;

import java.util.*;

public class Node<T> {
    private final T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
        this.data = data;
    }

    public static <T> Node<T> initOneWay(Collection<T> list) {
        if (list.size() == 0) return new Node<>(null);

        Iterator<T> iterator = list.iterator();
        Node<T> head = new Node<>(iterator.next());
        Node<T> curr = head;
        while (iterator.hasNext()){
            curr.next = new Node<>(iterator.next());
            curr = curr.next;
        }

        return head;
    }

    public int size() {
        int size = 0;
        Node<T> p = this;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }

    public boolean hasDuplicatedData() {
        int size = 0;
        Set<T> hashSet = new HashSet<>();
        Node<T> p = this;

        while (p != null) {
            hashSet.add(p.data);
            size++;
            p = p.next;
        }

        return hashSet.size() != size;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<T> p = this;
        while (p != null) {
            sb.append(p.data);
            if (p.next != null) sb.append(" => ");
            p = p.next;
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
