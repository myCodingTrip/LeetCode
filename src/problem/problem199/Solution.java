package problem.problem199;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    //2ms
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> traverseQueue = new LinkedList<>();
        Queue<TreeNode> storageQueue = new LinkedList<>();
        traverseQueue.offer(root);

        while (!traverseQueue.isEmpty()) {
            while (!traverseQueue.isEmpty()) {
                TreeNode poll = traverseQueue.poll();
                if (traverseQueue.isEmpty()) {
                    res.add(poll.val);
                }
                if (poll.left != null)
                    storageQueue.offer(poll.left);
                if (poll.right != null)
                    storageQueue.offer(poll.right);
            }
            while (!storageQueue.isEmpty()) {
                traverseQueue.offer(storageQueue.poll());
            }
        }
        return res;
    }
}
