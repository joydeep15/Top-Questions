package trees;

import utilities.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigZagOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        populate(root, 1, result);

        boolean even = false;
        for (List<Integer> items : result) {
            if (even) {
                Collections.reverse(items);
            }
            even = !even;
        }

        return result;


    }

    public void populate(TreeNode root, int level, List<List<Integer>> result){

        if(root==null){
            return;
        }

        if(result.size() < level){
            result.add(new ArrayList<>());
        }

        result.get(level-1).add((Integer)root.val);
        populate(root.left, level+1, result);
        populate(root.right, level+1, result);

    }
}
