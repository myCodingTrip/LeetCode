package problem230;

import common.TreeNode;
import common.TreeUtil;

//0ms 100%
class Solution {

    private int count = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    //中序遍历
    private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        count++;
        //已找到结果，直接回溯
        if (count == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(
                TreeUtil.arrToTree(new Integer[]{3, 1, 4, null, 2}), 4));
    }
}