package problem199;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution2 {
    // 1ms
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> traverseQueue = new LinkedList<>();
        traverseQueue.offer(root);

        while (!traverseQueue.isEmpty()) {
            int size = traverseQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = traverseQueue.poll();
                if (i == size - 1) {
                    res.add(poll.val);
                }
                if (poll.left != null)
                    traverseQueue.offer(poll.left);
                if (poll.right != null)
                    traverseQueue.offer(poll.right);
            }
        }

        return res;
    }
}