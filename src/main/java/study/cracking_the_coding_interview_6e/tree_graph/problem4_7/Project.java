package study.cracking_the_coding_interview_6e.tree_graph.problem4_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {

    private final List<Project> children = new ArrayList<>();
    private final Map<String, Project> map = new HashMap<>();
    private final String name;
    private State state = State.BLANK;

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    public List<Project> getChildren() {
        return children;
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

    public enum State {
        COMPLETE, PARTIAL, BLANK
    }
}
