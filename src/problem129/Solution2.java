package problem129;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//0ms 100%
class Solution2 {

    private List<Integer> sums = new ArrayList<>();

    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        for (Integer sum : sums) {
            res += sum;
        }
        return res;
    }

    private void dfs(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            sum = sum * 10 + node.val;
            res += sum;
            return;
        }
        if (node.left != null)
            dfs(node.left, 10 * sum + node.val);
        if (node.right != null)
            dfs(node.right, 10 * sum + node.val);
    }
}