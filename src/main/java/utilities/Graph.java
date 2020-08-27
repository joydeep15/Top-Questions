package utilities;

import java.util.*;

public class Graph<T> {

    //All elements should be unique
    private Map<T, Set<T>> graphStore = new HashMap<>();

    public void addVertex(T vertex){

        if( ! graphStore.containsKey(vertex) )
            graphStore.put(vertex, new HashSet<T>());

    }

    public void addEdge(T src, T target, boolean bidirectional){

        if(!graphStore.containsKey(src)) {
            addVertex(src);
        }

        if(!graphStore.containsKey(target)) {
            addVertex(target);
        }

        graphStore.get(src).add(target);
        if(bidirectional){
            graphStore.get(target).add(src);
        }
    }

    public int getVertexCount(){
        return graphStore.keySet().size();
    }

    public boolean hasVertex(T vertex){
        return graphStore.containsKey(vertex);
    }

    public boolean hasEdge(T src, T target){
        return graphStore.get(src).contains(target);
    }

    public Set<T> getVertices(){
        return graphStore.keySet();
    }

    public Iterator<T> getEdges(T vertex){
        return graphStore.get(vertex).iterator();
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<T, Set<T>> entry : graphStore.entrySet()){
            sb.append(entry.getKey()).append(": ");
            for(T value : entry.getValue()){
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();

    }

}
