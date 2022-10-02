package Study.Cracking_The_Coding_Interview_6E.Tree_Graph.problem4_1;

import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.Graph;
import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.MultiNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PathExistenceCheckerTest {

    @Test
    @DisplayName("경로 존재 여부 확인")
    public void case1() {
        //given
        Graph graph = new Graph(5, nodes -> {
            nodes.get(0).setChildren(nodes.get(1));
            nodes.get(1).setChildren(nodes.get(2), nodes.get(4));
            nodes.get(3).setChildren(nodes.get(1));
            nodes.get(4).setChildren(nodes.get(2));
        });

        //when & then
        List<MultiNode> multiNodes = graph.getNodes();
        assertThat(PathExistenceChecker.check(graph, multiNodes.get(0), multiNodes.get(4))).isTrue();
        assertThat(PathExistenceChecker.check(graph, multiNodes.get(0), multiNodes.get(2))).isTrue();
        assertThat(PathExistenceChecker.check(graph, multiNodes.get(0), multiNodes.get(3))).isFalse();
        assertThat(PathExistenceChecker.check(graph, multiNodes.get(3), multiNodes.get(4))).isTrue();
        assertThat(PathExistenceChecker.check(graph, multiNodes.get(4), multiNodes.get(3))).isFalse();
    }

}
