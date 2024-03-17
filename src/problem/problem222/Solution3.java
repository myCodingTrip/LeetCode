package problem.problem222;

import common.TreeNode;
import common.TreeUtil;

public class Solution3 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int completeDepth = getCompleteDepth(root);
        int leafRightIdx = (int) Math.pow(2, completeDepth) - 1;
        int l = 0;
        int r = leafRightIdx;
        //[l,r]
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (exists(root, mid, completeDepth, leafRightIdx)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
//        System.out.println(depth + " " + l);
        return (int) Math.pow(2, completeDepth) + r;
    }

    private boolean exists(TreeNode root, int idx, int depth, int leafNum) {
        TreeNode node = root;
        int left = 0;
        int right = leafNum;
        for (int i = 0; i < depth; i++) {
            int mid = left / 2 + right / 2;
            if (mid >= idx) {
                node = node.left;
                right = mid;
            } else {
                node = node.right;
                left = mid + 1;
            }
        }
        return node != null;
    }


    private int getCompleteDepth(TreeNode root) {
        int res = 0;
        TreeNode node = root;
        while (node != null && node.left != null) {
            res++;
            node = node.left;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().countNodes(
                TreeUtil.arrToTree(new Integer[]{1})));
    }
}
