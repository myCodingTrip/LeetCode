package problem.problem98;

import common.TreeNode;

class Solution {
    //0ms 100%
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        int val = root.val;
        if (root.left == null && root.right == null) return true;
        if (root.left != null) {
            if (!isValidBST(root.left) || val <= max(root.left)) return false;
        }
        if (root.right != null) {
            if (!isValidBST(root.right) || val >= min(root.right)) return false;
        }
        //当前节点的值必须大于左子树的最大值，小于右子树的最小值
        return true;
    }

    private int min(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    private int max(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }
}
