package Study.Cracking_The_Coding_Interview_6E.Stack_Queue.problem3_2;

import java.util.Stack;

public class MinStackV1 extends Stack<MinStackV1.NodeWithMin> {

    public void push(int value) {
        int min = Math.min(value, min());
        super.push(new NodeWithMin(value, min));
    }

    public int popAndGetValue() {
        return super.pop().value;
    }

    public int min() {
        return this.isEmpty() ? Integer.MAX_VALUE : super.peek().min;
    }

    static class NodeWithMin {
        private final int value;
        private final int min;

        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

}
