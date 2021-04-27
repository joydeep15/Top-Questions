package DisjointSets;

//TODO path compression
public class DSU {

    int[] parent;
    int[] rank;
    //rank is height of the tree

    public DSU(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        rank = new int[size];
    }

    public int find(int node){

        int root = node;
        while (parent[root] != root){
            root = parent[root];
        }
        return root;

    }


    public boolean union(int node1, int node2){
        int x_root = find(node1);
        int y_root = find(node2);

        if(x_root == y_root){
            return false;
        }

            /*
                Rank is representative of the height of the tree of dsu. if the rank is not equal,
                then we push the smaller rank tree under the higher rank tree, effectively neither
                increasing the rank of the higher rank tree not that of the smaller rank tree.
                If the rank is equal, whichever tree u attach underneath the other, u end up increasing
                the rank of the tree being attached to, by 1.
            * */
        if(rank[x_root] > rank[y_root]){
            parent[y_root] = x_root;
        }else if (rank[y_root] > rank[x_root]){
            parent[x_root] = y_root;
        }else {
            parent[x_root] = y_root;
            rank[y_root]++;
        }

        return true;
    }


}
