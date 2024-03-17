package problem.problem437;

import common.TreeNode;

class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = dealOneNode(root, sum);
        if (root.left != null)
            res += pathSum(root.left, sum);
        if (root.right != null)
            res += pathSum(root.right, sum);
        return res;
    }

    //从某一节点出发向下的路径数
    public int dealOneNode(TreeNode node, int sum) {
        int res = 0;
        //注意递归终止问题
        if (sum == node.val) {
            res++;
        }
        // 递归调用写在if中
        if (node.left != null)
            res += dealOneNode(node.left, sum - node.val);
        if (node.right != null)
            res += dealOneNode(node.right, sum - node.val);
        return res;
    }
}
