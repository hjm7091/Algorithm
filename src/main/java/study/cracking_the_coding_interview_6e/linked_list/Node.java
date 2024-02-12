package study.cracking_the_coding_interview_6e.linked_list;

import java.security.InvalidParameterException;
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

    public Node<T> copy() {
        Node<T> curr = null, head = null;
        for (T data : getDataList()) {
            if (curr == null) {
                curr = new Node<>(data);
                head = curr;
            } else {
                curr.setNext(new Node<>(data));
                curr = curr.getNext();
            }
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

    public Node<T> reverse() {
        List<Node<T>> nodes = getNodeList();
        Collections.reverse(nodes);

        for (int i = 0; i < nodes.size(); i++) {
            Node<T> next = i == nodes.size() - 1 ? null : nodes.get(i + 1);
            nodes.get(i).setNext(next);
        }

        return nodes.get(0);
    }

    public List<T> getDataList() {
        List<T> data = new ArrayList<>();
        data.add(this.data);
        Node<T> curr = this.next;
        while (curr != null) {
            data.add(curr.getData());
            curr = curr.next;
        }
        return data;
    }

    public List<Node<T>> getNodeList() {
        List<Node<T>> nodes = new ArrayList<>();
        nodes.add(this);
        Node<T> curr = this.next;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }
        return nodes;
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

    public Node<T> getTail() {
        Node<T> curr = this;
        while (true) {
            if (curr.next == null) return curr;
            curr = curr.next;
        }
    }

    public Node<T> getNthNode(int n) {
        if (n < 0) throw new InvalidParameterException("Method parameter 'n' must not be negative.");
        if (n >= this.size()) throw new InvalidParameterException("Method parameter 'n' must be smaller than node's size.");
        Node<T> curr = this;
        while (n > 0 && curr != null) {
            curr = curr.next;
            n--;
        }
        return curr;
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

        List<T> these = getDataList();
        List<?> those = node.getDataList();

        if (these.size() != those.size()) return false;

        boolean same = true;
        for (int i = 0; i < those.size(); i++) {
            T currThis = these.get(i);
            Object currThose = those.get(i);
            same &= currThis.equals(currThose);
        }
        return same;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDataList());
    }
}
