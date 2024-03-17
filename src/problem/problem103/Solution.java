package problem.problem103;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> traverseQueue = new LinkedList<>();
        Queue<TreeNode> storageQueue = new LinkedList<>();
        traverseQueue.offer(root);
        boolean order = true;
        while (!traverseQueue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            while (!traverseQueue.isEmpty()) {
                TreeNode poll = traverseQueue.poll();
                if (order) {
                    layer.add(poll.val);
                } else {
                    layer.add(0, poll.val);
                }
                if (poll.left != null)
                    storageQueue.offer(poll.left);
                if (poll.right != null)
                    storageQueue.offer(poll.right);
            }
            order = !order;
            res.add(layer);
            while (!storageQueue.isEmpty()) {
                traverseQueue.offer(storageQueue.poll());
            }
        }
        return res;
    }
}
