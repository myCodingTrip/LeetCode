package problem236;

import common.TreeNode;

class Solution {
    //7ms 99.93%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左右子树都能通向p/q
        if (left != null && right != null) return root;
            //左子树能通向p&q
        else if (left != null) return left;
            //右子树能通向p&q
        else if (right != null) return right;
        else return null;
    }
}