package Study.Cracking_The_Coding_Interview_6E.Stack_Queue.problem3_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MySetOfStacksTest {

    @Test
    @DisplayName("기본 동작 확인")
    public void case1() {
        //given
        int size = 5;
        MySetOfStacks<Integer> mySetOfStacks = new MySetOfStacks<>(size);

        //when
        for (int i = 0; i < size + 1; i++) {
            mySetOfStacks.push(i);
        }

        //then
        assertThat(mySetOfStacks.size()).isEqualTo(6);
        assertThat(mySetOfStacks.pop()).isEqualTo(5);
        assertThat(mySetOfStacks.pop()).isEqualTo(4);
        assertThat(mySetOfStacks.popAt(0)).isEqualTo(3);
        assertThrows(InvalidParameterException.class, () -> mySetOfStacks.popAt(-1));
        assertThrows(IllegalStateException.class, () -> mySetOfStacks.popAt(1));
    }

}
