package problem.problem235;

import common.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        return lowestCommonAncestor(root, min, max);
    }

    public TreeNode lowestCommonAncestor(TreeNode node, int small, int big) {
        if (node == null) return null;

        if (node.val < small)
            return lowestCommonAncestor(node.right, small, big);
        else if (node.val > big)
            return lowestCommonAncestor(node.left, small, big);
        else return node;
    }
}
