package Study.Cracking_The_Coding_Interview_6E.Stack_Queue.problem3_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinStackV1Test {

    @Test
    public void test1() {
        MinStackV1 stack = new MinStackV1();
        stack.push(3);
        assertThat(stack.min() == 3).isTrue();
        stack.push(2);
        assertThat(stack.min() == 2).isTrue();
        stack.push(1);
        assertThat(stack.min() == 1).isTrue();
    }

}
