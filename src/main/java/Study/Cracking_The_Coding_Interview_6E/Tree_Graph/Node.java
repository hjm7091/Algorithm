package Study.Cracking_The_Coding_Interview_6E.Tree_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {

    private final String name;

    private final List<Node> children = new ArrayList<>();

    private State state = State.Unvisited;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(Node... children) {
        this.children.addAll(Arrays.asList(children));
    }

    @Override
    public String toString() {
        return String.format("Node(%s)", this.name);
    }

    public enum State {
        Unvisited, Visited
    }

}
