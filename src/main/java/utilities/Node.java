package utilities;

import java.util.List;

public class Node {

    //GFG Tree Format
    public Integer data;
    public Node left;
    public Node right;

    public Node(Integer x){
        data = x;}
    public Node(){}

    /**
     *
     * @param tree comma separated tree nodes
     * @return
     */
    public Node createTree(List<Integer> nodes) {

        if (nodes.isEmpty()) {
            return new Node();
        }

        int i = 0;
        Node root = createTree(nodes, i);
        return root;

    }

    private Node createTree(List<Integer> nodes, Integer i) {

        if (i >= nodes.size()) {
            return null;
        }

        Node node = new Node(nodes.get(i));
        node.left = createTree(nodes, 2 * i + 1);
        node.right = createTree(nodes, 2 * i + 2);

        return node;

    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}