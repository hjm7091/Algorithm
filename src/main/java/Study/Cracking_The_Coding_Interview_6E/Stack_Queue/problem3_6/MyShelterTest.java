package Study.Cracking_The_Coding_Interview_6E.Stack_Queue.problem3_6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyShelterTest {

    @Test
    @DisplayName("기본 동작 확인1")
    public void case1() {
        //given
        MyShelter myShelter = new MyShelter();

        //when
        myShelter.enqueue(new Cat("cat1"));
        myShelter.enqueue(new Cat("cat2"));
        myShelter.enqueue(new Dog("dog1"));
        myShelter.enqueue(new Dog("dog2"));

        //then
        assertThat(myShelter.dequeueCat().toString()).contains("cat1");
        assertThat(myShelter.dequeueCat().toString()).contains("cat2");
        assertThat(myShelter.dequeueDog().toString()).contains("dog1");
        assertThat(myShelter.dequeueDog().toString()).contains("dog2");
    }

    @Test
    @DisplayName("기본 동작 확인2")
    public void case2() {
        //given
        MyShelter myShelter = new MyShelter();

        //when
        myShelter.enqueue(new Cat("cat1"));
        myShelter.enqueue(new Dog("dog1"));
        myShelter.enqueue(new Dog("dog2"));
        myShelter.enqueue(new Cat("cat2"));

        //then
        assertThat(myShelter.dequeueAny().getName()).isEqualTo("cat1");
        assertThat(myShelter.dequeueAny().getName()).isEqualTo("dog1");
        assertThat(myShelter.dequeueAny().getName()).isEqualTo("dog2");
        assertThat(myShelter.dequeueAny().getName()).isEqualTo("cat2");
    }

}
