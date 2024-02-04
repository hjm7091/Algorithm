package study.cracking_the_coding_interview_6e.stack_queue.problem3_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class StackSorterTest {

    @Test
    @DisplayName("기본 동작 확인")
    public void case1() {
        //given
        Stack<Integer> stack = new Stack<>();

        //when
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        StackSorter.sort(stack);

        //then
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(5);
        assertThat(stack.isEmpty()).isTrue();
    }

}
