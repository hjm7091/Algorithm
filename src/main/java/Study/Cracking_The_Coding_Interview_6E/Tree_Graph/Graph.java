package Study.Cracking_The_Coding_Interview_6E.Tree_Graph;

import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.Node.State;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Graph {

    private final List<Node> nodes = new ArrayList<>();

    public Graph(int size, Consumer<List<Node>> association) {
        for (int i = 0; i < size; i++) {
            nodes.add(new Node(String.valueOf(i)));
        }
        association.accept(this.nodes);
    }

    public void undoVisitHistory() {
        for (Node node : this.nodes) {
            node.setState(State.Unvisited);
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
