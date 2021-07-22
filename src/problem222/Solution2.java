package problem222;

import common.TreeNode;
import common.TreeUtil;

class Solution2 {

    public int countNodes(TreeNode root) {
        // if the tree is empty
        if (root == null) return 0;

        int d = computeDepth(root);
        // if the tree contains 1 node
        if (d == 0) return 1;

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Perform binary search to check how many nodes exist.
        int l = 1, r = (int) Math.pow(2, d) - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (exists(mid, d, root)) l = mid + 1;
            else r = mid - 1;
        }

        // The tree contains 2**d - 1 nodes on the first (d - 1) levels
        // and left nodes on the last level.
        return (int) Math.pow(2, d) - 1 + l;
    }

    // Return tree depth in O(d) time.
    private int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            ++d;
        }
        return d;
    }

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // 最后一级节点的枚举范围是0到2^d - 1（左->右）。
    // Return True if last level node idx exists. 如果最后一级节点idx存在，则返回True。
    // Binary search with O(d) complexity. 具有O（d）复杂度的二进制搜索。
    private boolean exists(int idx, int d, TreeNode node) {
        System.out.println(idx);
        int left = 0, right = (int) Math.pow(2, d) - 1;
        int pivot;
        for (int i = 0; i < d; ++i) {
            pivot = left + (right - left) / 2;
            System.out.println(left + " " + right + " " + pivot);
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().countNodes(
                TreeUtil.arrToTree(new Integer[]{1, 2, 3, 4, 5, 6})));
    }
}