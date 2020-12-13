package utilities;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphNode<T> {

    T name;
    List<GraphNode<T>> edges;

    public GraphNode(T name){
        this.name = name;
        edges = new ArrayList<>();
    }

    public List<GraphNode<T>> getEdges() {
        return edges;
    }

    public T getName() {
        return name;
    }


}
