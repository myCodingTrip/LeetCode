package problem113;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//1ms 99.98%
class Solution {
    private List<Integer> temp = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode node, int residue) {
        ;
        temp.add(node.val);
        if (isLeaf(node)) {
            if (residue == node.val) {
                res.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size() - 1);
            return;
        }
        if (node.left != null)
            dfs(node.left, residue - node.val);
        if (node.right != null)
            dfs(node.right, residue - node.val);
        temp.remove(temp.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}