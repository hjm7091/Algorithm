package Study.Cracking_The_Coding_Interview_6E.Tree_Graph.problem4_1;

import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.Graph;
import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.Node;
import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.Node.State;

import java.util.LinkedList;
import java.util.Queue;

public class PathExistenceChecker {

    public static boolean check(Graph g, Node n1, Node n2) {
        if (n1 == n2) return true;

        g.undoVisitHistory();
        Queue<Node> q = new LinkedList<>();
        q.add(n1);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            curr.setState(State.Visited);
            for (Node child : curr.getChildren()) {
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
