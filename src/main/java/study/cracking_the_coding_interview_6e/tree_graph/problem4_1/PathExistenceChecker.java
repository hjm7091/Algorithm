package study.cracking_the_coding_interview_6e.tree_graph.problem4_1;

import study.cracking_the_coding_interview_6e.tree_graph.Graph;
import study.cracking_the_coding_interview_6e.tree_graph.MultiNode;
import study.cracking_the_coding_interview_6e.tree_graph.MultiNode.State;

import java.util.LinkedList;
import java.util.Queue;

public class PathExistenceChecker {

    public static boolean check(Graph g, MultiNode n1, MultiNode n2) {
        if (n1 == n2) return true;

        g.undoVisitHistory();
        Queue<MultiNode> q = new LinkedList<>();
        q.add(n1);

        while (!q.isEmpty()) {
            MultiNode curr = q.poll();
            curr.setState(State.Visited);
            for (MultiNode child : curr.getChildren()) {
                if (child.getState() == State.Unvisited) {
                    if (child == n2) {
                        return true;
                    } else {
                        q.add(child);
                    }
                }
            }
        }

        return false;
    }

}
