package problem145;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node.left != null) dfs(node.left, res);
        if (node.right != null) dfs(node.right, res);
        res.add(node.val);
    }
}