package problem94;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node.left != null) dfs(node.left, res);
        res.add(node.val);
        if (node.right != null) dfs(node.right, res);
    }
}