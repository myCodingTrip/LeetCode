package problem337;

import common.TreeNode;

class Solution {
    public int rob(TreeNode root) {
        int[] arr = dfs(root);
        return Math.max(arr[0], arr[1]);
    }

    //index arr[0]代表不偷当前节点，所能得到的最大值，arr[1]代表偷当前节点，所能得到的最大值
    //不偷当前节点，就可以偷两个孩子
    private int[] dfs(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) return arr;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        arr[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        arr[1] = root.val + left[0] + right[0];
        return arr;
    }
}