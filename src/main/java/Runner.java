import utilities.Graph;

public class Runner {

    public static void main(String[] args) {

        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0, 1, false);
        graph.addEdge(0, 2, false);
        graph.addEdge(0, 3, false);
        graph.addEdge(3, 5, false);
        graph.addEdge(2, 4, false);
        graph.addEdge(2, 1, false);

        System.out.println(graph.toString());

    }


}
