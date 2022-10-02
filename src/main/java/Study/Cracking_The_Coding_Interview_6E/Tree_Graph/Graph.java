package Study.Cracking_The_Coding_Interview_6E.Tree_Graph;

import Study.Cracking_The_Coding_Interview_6E.Tree_Graph.MultiNode.State;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Graph {

    private final List<MultiNode> multiNodes = new ArrayList<>();

    public Graph(int size, Consumer<List<MultiNode>> association) {
        for (int i = 0; i < size; i++) {
            multiNodes.add(new MultiNode(String.valueOf(i)));
        }
        association.accept(this.multiNodes);
    }

    public void undoVisitHistory() {
        for (MultiNode multiNode : this.multiNodes) {
            multiNode.setState(State.Unvisited);
        }
    }

    public List<MultiNode> getNodes() {
        return multiNodes;
    }
}
