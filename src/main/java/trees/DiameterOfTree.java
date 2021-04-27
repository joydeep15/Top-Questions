package trees;

import utilities.TreeNode;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        getHeight(root, diameter);
        return diameter[0];
    }

    public int getHeight(TreeNode root, int[] diameter){

        if(root == null){
            return 0;
        }

        int leftHeight = getHeight(root.left, diameter);
        int rightHeight = getHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }


}
