package trees;

import utilities.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class RightViewTree {
}


class Solution {
    int maxLevel = -1;

    public List<Integer> rightSideView(TreeNode root) {
        maxLevel = -1;
        List<Integer> result = new ArrayList<>();
        rightSideView(result, root, 0);
        return result;
    }

    private void rightSideView(List<Integer> result, TreeNode root, int level) {

        if (root == null) {
            return;
        }

        if (level > maxLevel) {
            result.add((Integer) root.val);
            maxLevel = level;
        }

        rightSideView(result, root.right, level + 1);
        rightSideView(result, root.left, level + 1);

    }
}
