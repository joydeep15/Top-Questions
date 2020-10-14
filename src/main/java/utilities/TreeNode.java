package utilities;

import java.util.List;

public class TreeNode<T> {

    public T val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T x){val = x;}
    public TreeNode(){}

    /**
     *
     * @param tree comma separated tree nodes
     * @return
     */
    public TreeNode<T> createTree(List<T> nodes) {

        if (nodes.isEmpty()) {
            return new TreeNode<>();
        }

        int i = 0;
        TreeNode<T> root = createTree(nodes, i);
        return root;

    }

    private TreeNode<T> createTree(List<T> nodes, int i) {

        if (i >= nodes.size()) {
            return null;
        }

        TreeNode<T> node = new TreeNode<>(nodes.get(i));
        node.left = createTree(nodes, 2 * i + 1);
        node.right = createTree(nodes, 2 * i + 2);

        return node;

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}