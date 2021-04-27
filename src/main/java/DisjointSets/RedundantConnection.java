package DisjointSets;

//https://leetcode.com/problems/redundant-connection/
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {

        DSU dsu = new DSU(edges.length);
        for (int[] edge : edges){
            int x = edge[0] -1;
            int y = edge[1] -1;

            if(!dsu.union(x, y)){
                return edge;
            }
        }

        throw new IllegalArgumentException("No excess edge");
    }

}
