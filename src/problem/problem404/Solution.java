package problem.problem404;

import common.TreeNode;

//0ms 100%
class Solution {

    private int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node.left != null) {
            if (isLeaf(node.left)) {
                res += node.left.val;
            } else {
                dfs(node.left);
            }
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
