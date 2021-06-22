package graph;

import graph.DisjointSets.DSU;

//https://leetcode.com/problems/graph-valid-tree/
public class IsGraphTree {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length!=n-1){
            return false;
        }

        DSU dsu = new DSU(n);
        for(int[] edge : edges){
            if(!dsu.union(edge[0], edge[1])){
                return false;
            }
        }

        return true;
    }
}
