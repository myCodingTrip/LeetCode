package problem222;

import common.TreeNode;

//100%
class Solution {
    private int res = 0;

    public int countNodes(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            res++;
            dfs(node.left);
            dfs(node.right);
        }
    }
}