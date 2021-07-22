package problem108;

import common.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return sortedArrayToBST(nums, 0, n - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        //第一次写漏了这一句
        if (left > right) return null;
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}