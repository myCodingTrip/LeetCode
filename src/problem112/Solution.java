package problem112;

import common.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        //注意递归终止问题
        if (root.left == null && root.right == null) {
            if (sum == root.val) return true;
        } else {
            // 递归调用写在if中
            if (root.left != null && hasPathSum(root.left, sum - root.val))
                return true;
            if (root.right != null && hasPathSum(root.right, sum - root.val))
                return true;
        }
        return false;
    }
}