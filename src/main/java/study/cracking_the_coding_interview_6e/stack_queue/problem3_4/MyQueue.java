package study.cracking_the_coding_interview_6e.stack_queue.problem3_4;

import java.util.Stack;

public class MyQueue<T> {

    private final Stack<T> stackNewest = new Stack<>(), stackOldest = new Stack<>();

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    public T peek() {
        shiftStack();
        return stackOldest.peek();
    }

    public T pop() {
        shiftStack();
        return stackOldest.pop();
    }

    private void shiftStack() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}
