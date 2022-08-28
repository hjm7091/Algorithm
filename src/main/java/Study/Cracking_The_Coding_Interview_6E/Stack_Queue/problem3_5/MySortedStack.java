package Study.Cracking_The_Coding_Interview_6E.Stack_Queue.problem3_5;

import java.util.Stack;

public class MySortedStack<T extends Comparable<T>> {

    private final Stack<T> temp = new Stack<>();
    private final Stack<T> stack = new Stack<>();

    public void push(T item) {
        while (!stack.isEmpty()) {
            T top = stack.peek();
            if (top.compareTo(item) > 0) break;
            temp.push(top);
            stack.pop();
        }

        stack.push(item);

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public T pop() {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
