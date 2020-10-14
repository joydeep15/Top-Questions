package trees;

import utilities.TreeNode;

import java.util.Arrays;
import java.util.List;

public class LCA {


    public static void main(String[] args) {

        Integer[] ip = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        List<Integer> l = Arrays.asList(ip);
        TreeNode<Integer> t = new TreeNode<>();

        TreeNode<Integer> root = t.createTree(l);
        TreeNode<Integer> p = new TreeNode<>(5);
        TreeNode<Integer> q = new TreeNode<>(4);

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

        if (leftResult != null && rightResult != null) {
            //found
            return root;
        }

        return leftResult == null ? rightResult : leftResult;

    }
}
