package Study.Cracking_The_Coding_Interview_6E.Stack_Queue.problem3_3;

import java.security.InvalidParameterException;
import java.util.*;

public class MySetOfStacks<T> extends Stack<T> {

    private final int MAX_SIZE;

    private final List<Stack<T>> stacks = new ArrayList<>();

    private int idx = 0;

    public MySetOfStacks(int size) {
        this.MAX_SIZE = size;
        stacks.add(new Stack<>());
    }

    @Override
    public T push(T item) {
        Stack<T> childStack = stacks.get(idx);
        if (childStack.size() == MAX_SIZE) {
            stacks.add(new Stack<>());
            idx++;
        }
        return stacks.get(idx).push(item);
    }

    @Override
    public synchronized T pop() {
        Stack<T> childStack = stacks.get(idx);
        while (idx > 0 && childStack.isEmpty()) {
            stacks.remove(idx);
            childStack = stacks.get(--idx);
        }
        return childStack.pop();
    }

    public synchronized T popAt(int index) {
        if (index < 0) throw new InvalidParameterException(String.format("Index %d is not allowed here.", index));

        if (index > idx) throw new IllegalStateException(String.format("There's no valid child stack with index %d", index));

        return Objects.requireNonNull(stacks.get(index)).pop();
    }

    @Override
    public synchronized int size() {
        return stacks.stream().map(Vector::size).reduce(0, Integer::sum);
    }
}
