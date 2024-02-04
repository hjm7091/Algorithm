package study.cracking_the_coding_interview_6e.tree_graph.problem4_3;

import study.cracking_the_coding_interview_6e.tree_graph.BinaryNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthListGenerator {

    public static Map<Integer, List<Integer>> lists(BinaryNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        search(root, map, 1);
        return map;
    }

    private static void search(BinaryNode root, Map<Integer, List<Integer>> map, int depth) {
        if (root == null) return;
        List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
        list.add(root.getValue());
        map.put(depth, list);
        search(root.getLeftChild(), map, depth + 1);
        search(root.getRightChild(), map, depth + 1);
    }

}
