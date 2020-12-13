package trees;

class Node{
    int data;
    Node left,right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}

class Height{
   int height=0;
}

public class BalancedTree {

    boolean isBalanced(Node root)
    {

        return isBalanced(root, new Height());
    }

    private boolean isBalanced(Node root, Height height) {

        if (root == null) {
            height.height = 0;
            return true;
        }

        Height leftHeight = new Height();
        Height rightHeight = new Height();
        boolean isLeftBalanced = isBalanced(root.left, leftHeight);
        boolean isRightBalanced = isBalanced(root.right, rightHeight);


        int height_left = leftHeight.height;
        int right_height = rightHeight.height;

        int currentHeight = Math.max(height_left, right_height) + 1;
        height.height = currentHeight;

        if (Math.abs(height_left - right_height) > 1) {
            return false;
        }

        return isLeftBalanced && isRightBalanced;

    }
}
