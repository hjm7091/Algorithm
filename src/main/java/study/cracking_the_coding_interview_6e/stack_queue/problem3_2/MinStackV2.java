package study.cracking_the_coding_interview_6e.stack_queue.problem3_2;

import java.util.Stack;

public class MinStackV2 extends Stack<Integer> {

    private final Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        if (value <= min()) {
            minStack.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        Integer value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        return value;
    }

    public int min() {
        return minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }
}
