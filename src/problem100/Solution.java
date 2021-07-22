package problem100;

import common.TreeNode;

class Solution {
    //100%
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else if (p.val != q.val) return false;
        else return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}