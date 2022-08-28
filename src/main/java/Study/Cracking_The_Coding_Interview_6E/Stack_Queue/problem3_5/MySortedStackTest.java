package Study.Cracking_The_Coding_Interview_6E.Stack_Queue.problem3_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MySortedStackTest {

    @Test
    @DisplayName("기본 동작 확인")
    public void case1() {
        //given
        MySortedStack<Integer> mySortedStack = new MySortedStack<>();

        //when
        mySortedStack.push(3);
        mySortedStack.push(2);
        mySortedStack.push(5);
        mySortedStack.push(4);

        //then
        assertThat(mySortedStack.pop()).isEqualTo(2);
        assertThat(mySortedStack.pop()).isEqualTo(3);
        assertThat(mySortedStack.pop()).isEqualTo(4);
        assertThat(mySortedStack.pop()).isEqualTo(5);
        assertThat(mySortedStack.isEmpty()).isTrue();
    }

}
