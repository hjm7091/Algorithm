package study.cracking_the_coding_interview_6e.tree_graph;

import study.cracking_the_coding_interview_6e.tree_graph.MultiNode.State;

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
