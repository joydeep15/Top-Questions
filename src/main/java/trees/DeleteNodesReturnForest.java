package trees;

import utilities.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        if (to_delete == null || root == null || to_delete.length == 0) {
            return new ArrayList<>();
        }

        Set<Integer> set = new HashSet<>();
        for (int a : to_delete) {
            set.add(a);
        }

        List<TreeNode> forest = new ArrayList<>();
        dfsDelete(root, set, forest);
        if (!set.contains(root.val)) {
            forest.add(0, root);
        }else {
            if (root.left != null) {
                forest.add(root.left);
            }

            if (root.right != null) {
                forest.add(root.right);
            }
        }
        return forest;

    }

    private void dfsDelete(TreeNode root, Set<Integer> set, List<TreeNode> forest) {

        if (root == null) {
            return;
        }

        dfsDelete(root.left, set, forest);
        dfsDelete(root.right, set, forest);

        if (root.left != null && set.contains(root.left.val)) {
            deleteAndAdd(root,0, forest);
        }

        if (root.right != null && set.contains(root.right.val)) {
            deleteAndAdd(root,1, forest);
        }

    }

    private void deleteAndAdd(TreeNode root, int direction, List<TreeNode> forest) {

        TreeNode toDelete = null;

        if (direction == 0) {
            toDelete = root.left;
            root.left = null;
        }else{
            toDelete = root.right;
            root.right = null;
        }

        //needs to be deleted
        if (toDelete.left != null) {
            forest.add(toDelete.left);
        }
        if (toDelete.right != null) {
            forest.add(toDelete.right);
        }

        toDelete.left = null;
        toDelete.right = null;

    }
}
