package trees;

import utilities.Node;

import java.lang.reflect.Array;
import java.util.*;

class Solution {

    static int maxLevel = -1;
    public ArrayList<Integer> leftView(Node root) {
        maxLevel = -1;
        ArrayList<Integer> result = new ArrayList<>();
        populateLeftView(result, 0, root);
        return result;
    }

    private  void populateLeftView(List<Integer> result, int level, Node root) {

        if (root == null) {
            return;
        }

        if (level > maxLevel) {
            result.add(root.data);
            maxLevel = level;
        }

        populateLeftView( result, level + 1, root.left);
        populateLeftView( result, level + 1, root.right);
    }
}

public class LeftViewTree {

    public static void main(String[] args) {

        List<Integer> tree = Arrays.asList(3,4,null,2,7,null,2,1,null,9,1);
        Node root = new Node().createTree(tree);
        List<Integer> leftView = new Solution().leftView(root);
        leftView.forEach(System.out::println);

    }

}
