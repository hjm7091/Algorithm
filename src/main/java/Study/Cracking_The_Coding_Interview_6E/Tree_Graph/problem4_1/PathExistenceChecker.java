package Study.Cracking_The_Coding_Interview_6E.Tree_Graph.problem4_1;

import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.Graph;
import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.MultiNode;
import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.MultiNode.State;

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
