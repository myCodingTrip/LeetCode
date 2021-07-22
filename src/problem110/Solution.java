package problem110;

import common.TreeNode;

class Solution {
    /**
     * 执行用时 :1 ms
     * 在所有 Java 提交中击败了99.79%的用户
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right)
                && (Math.abs(depth(root.left) - depth(root.right)) <= 1);
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}