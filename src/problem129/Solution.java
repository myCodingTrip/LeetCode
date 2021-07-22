package problem129;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//1ms 31%
class Solution {

    private List<Integer> sums = new ArrayList<>();
    private List<Integer> nodes = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        int res = 0;
        for (Integer sum : sums) {
            res += sum;
        }
        return res;
    }

    private void dfs(TreeNode node) {
        nodes.add(node.val);
        if (node.left == null && node.right == null) {
            int sum = 0;
            int mul = 1;
            for (int i = nodes.size() - 1; i >= 0; i--) {
                sum += nodes.get(i) * mul;
                mul *= 10;
            }
            sums.add(sum);
            nodes.remove(nodes.size() - 1);
            return;
        }
        if (node.left != null)
            dfs(node.left);
        if (node.right != null)
            dfs(node.right);
        nodes.remove(nodes.size() - 1);
    }
}