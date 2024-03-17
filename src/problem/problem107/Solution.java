package problem.problem107;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> traverseQueue = new LinkedList<>();
        Queue<TreeNode> storageQueue = new LinkedList<>();
        traverseQueue.offer(root);
        while (!traverseQueue.isEmpty()) {
            //存储一层的数据
            List<Integer> layerList = new ArrayList<>();
            while (!traverseQueue.isEmpty()) {
                TreeNode poll = traverseQueue.poll();
                layerList.add(poll.val);
                if (poll.left != null)
                    storageQueue.offer(poll.left);
                if (poll.right != null)
                    storageQueue.offer(poll.right);
            }
            res.add(0, layerList);
            while (!storageQueue.isEmpty()) {
                traverseQueue.offer(storageQueue.poll());
            }
        }
        return res;
    }
}
