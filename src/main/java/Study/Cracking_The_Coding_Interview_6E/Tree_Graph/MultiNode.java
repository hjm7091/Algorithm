package Study.Cracking_The_Coding_Interview_6E.Tree_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiNode {

    private final String name;

    private final List<MultiNode> children = new ArrayList<>();

    private State state = State.Unvisited;

    public MultiNode(String name) {
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

    public List<MultiNode> getChildren() {
        return children;
    }

    public void setChildren(MultiNode... children) {
        this.children.addAll(Arrays.asList(children));
    }

    @Override
    public String toString() {
        return String.format("MultiNode(%s)", this.name);
    }

    public enum State {
        Unvisited, Visited
    }

}
