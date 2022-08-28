package Study.Cracking_The_Coding_Interview_6E.Stack_Queue.problem3_4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyQueueTest {

    @Test
    @DisplayName("기본 동작 확인")
    public void case1() {
        //given
        MyQueue<Integer> myQueue = new MyQueue<>();

        //when
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);

        //then
        assertThat(myQueue.pop()).isEqualTo(1);
        assertThat(myQueue.pop()).isEqualTo(2);
        assertThat(myQueue.pop()).isEqualTo(3);
        assertThat(myQueue.pop()).isEqualTo(4);
    }

}
