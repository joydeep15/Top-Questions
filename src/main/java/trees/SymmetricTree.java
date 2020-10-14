package trees;

import utilities.TreeNode;

import java.util.Arrays;
import java.util.List;

public class SymmetricTree {

//    https://leetcode.com/problems/symmetric-tree/

    public static void main(String[] args) {
        Integer[] ip = {1,2,2,3,4,4,3};
//        Integer[] ip = {1, 2, 2, null, 3, null, 3};
        List<Integer> l = Arrays.asList(ip);
        TreeNode<Integer> t = new TreeNode<>();

        TreeNode<Integer> root = t.createTree(l);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}