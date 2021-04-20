package graph;

import utilities.GraphNode;

import java.util.*;

//https://www.geeksforgeeks.org/topological-sorting/
public class TopologicalSort {

    enum State{
        UNBUILT, BUILDING, BUILT;
    }
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
//        n2.getEdges().add(n5); //uncomment for cycle test

        nodes.add(n5);
        nodes.add(n4);
        nodes.add(n3);
        nodes.add(n2);
        nodes.add(n1);
        nodes.add(n0);

        System.out.println(topoLogicalSort(nodes));
    }

    private static String topoLogicalSort(List<GraphNode<Integer>> nodes) {

        List<Integer> stack = new ArrayList<>();

        Map<GraphNode<Integer>, State> buildState = new HashMap<>();
        for(GraphNode<Integer> node : nodes){
            buildState.put(node, State.UNBUILT);
        }

        for(GraphNode<Integer> node : nodes){

            if(buildState.get(node) == State.BUILT){
                continue;
            }

            boolean success = build(node, stack, buildState);

            if(!success){
                return "Graph Contains Cycle. Impossible to build";
            }

        }

        Collections.reverse(stack);

        return stack.toString();
    }

    private static boolean build(GraphNode<Integer> node, List<Integer> stack,
                              Map<GraphNode<Integer>, State> buildState) {

        if(buildState.get(node) == State.BUILT){
            return true;
        }

        if(buildState.get(node) == State.BUILDING){
            return false;
        }


        buildState.put(node, State.BUILDING);
        boolean success = true;
        for (GraphNode<Integer> childNode : node.getEdges()) {
            success = success && build(childNode, stack, buildState);
            if(!success){
                break;
            }
        }

        if(success){
            if(buildState.get(node) != State.BUILT){
                buildState.put(node, State.BUILT);
                stack.add(node.getName());
            }
        }

        return success;


    }
}
