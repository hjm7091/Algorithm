package Study.Cracking_The_Coding_Interview_6E.Tree_Graph.problem4_3;

import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.problem4_2.BinarySearchTreeGenerator;
import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.BinaryNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DepthListGeneratorTest {

    @Test
    @DisplayName("깊이의 리스트 생성")
    public void test1() {
        //given
        int[] arr = {1, 3, 5, 7, 9, 10, 16};

        //when
        BinaryNode root = BinarySearchTreeGenerator.createMinHeightBinarySearchTree(arr, 0, arr.length - 1);
        Map<Integer, List<Integer>> lists = DepthListGenerator.lists(root);

        //then
        System.out.println(lists);
        assertThat(lists.keySet().size()).isEqualTo(3);
    }

}
