package problem101;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    //10.06%
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        Stack<TreeNode> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size % 2 != 0) return false;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i < size / 2) {
                    stack.push(poll);
                } else {
                    TreeNode pop = stack.pop();
                    if (poll == null && pop != null) return false;
                    if (poll != null && pop == null) return false;
                    if (poll != null && poll.val != pop.val) return false;
                }
                if (poll != null) queue.offer(poll.left);
                if (poll != null) queue.offer(poll.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
    }
}