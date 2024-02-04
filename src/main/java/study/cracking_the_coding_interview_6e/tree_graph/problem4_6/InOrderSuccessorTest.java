package study.cracking_the_coding_interview_6e.tree_graph.problem4_6;

import study.cracking_the_coding_interview_6e.tree_graph.PointingParentNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InOrderSuccessorTest {

    @Test
    @DisplayName("root가 null인 경우")
    public void case1() {
        assertThat(InOrderSuccessor.findNext(null)).isNull();
    }

    @Test
    @DisplayName("right가 null인 경우")
    public void case2() {
        //given
        PointingParentNode root = new PointingParentNode(1, null);

        //when & then
        assertThat(InOrderSuccessor.findNext(root)).isNull();
    }

    @Test
    @DisplayName("오른쪽 서브 트리의 다양한 경우")
    public void case3() {
        //given
        PointingParentNode root = new PointingParentNode(3, null);
        PointingParentNode r = new PointingParentNode(5, root);
        PointingParentNode rl = new PointingParentNode(4, r);
        PointingParentNode rr = new PointingParentNode(6, r);
        r.setLeftChild(rl);
        r.setRightChild(rr);
        root.setRightChild(r);

        //when & then
        assertThat(InOrderSuccessor.findNext(root)).isEqualTo(rl);
        assertThat(InOrderSuccessor.findNext(rl)).isEqualTo(r);
        assertThat(InOrderSuccessor.findNext(r)).isEqualTo(rr);
        assertThat(InOrderSuccessor.findNext(rr)).isNull();
    }

}
