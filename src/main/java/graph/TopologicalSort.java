package graph;

import utilities.GraphNode;

import java.util.*;

//https://www.geeksforgeeks.org/topological-sorting/
public class TopologicalSort {

    public static void main(String[] args) {

        List<GraphNode<Integer>> nodes = new ArrayList<>();

        GraphNode<Integer> n5 = new GraphNode<>(5);
        GraphNode<Integer> n4 = new GraphNode<>(4);
        GraphNode<Integer> n3 = new GraphNode<>(3);
        GraphNode<Integer> n2 = new GraphNode<>(2);
        GraphNode<Integer> n1 = new GraphNode<>(1);
        GraphNode<Integer> n0 = new GraphNode<>(0);

        n5.getEdges().add(n2);
        n5.getEdges().add(n0);

        n4.getEdges().add(n0);
        n4.getEdges().add(n1);

        n3.getEdges().add(n1);

        n2.getEdges().add(n3);

        nodes.add(n5);
        nodes.add(n4);
        nodes.add(n3);
        nodes.add(n2);
        nodes.add(n1);
        nodes.add(n0);

//        Collections.reverse(nodes);
        System.out.println(topoLogicalSort(nodes));

    }

    private static String topoLogicalSort(List<GraphNode<Integer>> nodes) {

        List<Integer> stack = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for(GraphNode<Integer> node : nodes){
            if (visited.contains(node)) {
                continue;
            }

            traverse(node, stack, visited);

        }

        Collections.reverse(stack);

        return stack.toString();
    }

    private static void traverse(GraphNode<Integer> node, List<Integer> stack, Set<Integer> visited) {

        if (visited.contains(node.getName())) {
            return;
        }

        visited.add(node.getName());

        for (GraphNode<Integer> childNode : node.getEdges()) {
            traverse(childNode, stack, visited);
        }

        stack.add(node.getName());
    }
}
