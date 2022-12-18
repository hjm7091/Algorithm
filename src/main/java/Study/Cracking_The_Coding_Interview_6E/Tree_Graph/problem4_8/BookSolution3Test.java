package Study.Cracking_The_Coding_Interview_6E.Tree_Graph.problem4_8;

import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.BinaryNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookSolution3Test {

    @Test
    @DisplayName("검색할 두 노드가 같은 트리에 있는 경우")
    public void case1() {
        //given
        BinaryNode p = BinaryNode.of(7);
        BinaryNode q = BinaryNode.of(17);
        BinaryNode root = BinaryNode.of(20)
            .setLeftChild(
                BinaryNode.of(10)
                    .setLeftChild(
                        BinaryNode.of(5)
                            .setLeftChild(BinaryNode.of(3))
                            .setRightChild(p)
                    )
                    .setRightChild(
                        BinaryNode.of(15)
                            .setRightChild(q)
                    )
            )
            .setRightChild(BinaryNode.of(30));

        //when
        BinaryNode commonAncestor = BookSolution3.commonAncestor(root, p, q);

        //then
        assertThat(commonAncestor).isNotNull();
        assertThat(Objects.requireNonNull(commonAncestor).getValue()).isEqualTo(10);
    }

}
