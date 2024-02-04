package study.cracking_the_coding_interview_6e.tree_graph.problem4_7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class BookSolutionTest {

    @Test
    @DisplayName("순서에 사이클이 없는 경우")
    public void case1() {
        //given
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
            {"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}
        };

        //when
        Stack<Project> order = BookSolution.buildOrder(projects, dependencies);

        //then
        assertThat(order).isNotNull();
        List<String> collect = order.stream().map(Project::getName).collect(Collectors.toList());
        Collections.reverse(collect);
        System.out.println(collect);
    }

    @Test
    @DisplayName("순서에 사이클이 있는 경우")
    public void case2() {
        //given
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
            {"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}, {"a", "f"}
        };

        //when
        Stack<Project> order = BookSolution.buildOrder(projects, dependencies);

        //then
        assertThat(order).isNull();
    }

}
