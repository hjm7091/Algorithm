package Study.Cracking_The_Coding_Interview_6E.Stack_Queue.problem3_5;

import java.util.Stack;

public class StackSorter {

    public static <T extends Comparable<T>> void sort(Stack<T> s) {
        Stack<T> r = new Stack<>();
        while (!s.isEmpty()) {
            T tmp = s.pop();
            while (!r.isEmpty() && r.peek().compareTo(tmp) > 0) {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

}
