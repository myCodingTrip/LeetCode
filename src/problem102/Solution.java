package problem102;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0));
        int curLayer = -1;
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int layer = tuple.layer;
            if (layer > curLayer) {
                res.add(new ArrayList<>());
                curLayer++;
            }
            List<Integer> list = res.get(layer);
            list.add(tuple.node.val);
            if (tuple.node.left != null) {
                queue.offer(new Tuple(tuple.node.left, layer + 1));
            }
            if (tuple.node.right != null) {
                queue.offer(new Tuple(tuple.node.right, layer + 1));
            }
        }
        return res;
    }

    class Tuple {
        TreeNode node;
        int layer;

        public Tuple(TreeNode node, int layer) {
            this.node = node;
            this.layer = layer;
        }
    }
}