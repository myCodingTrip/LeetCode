package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtil {
    public static TreeNode arrToTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode poll = queue.poll();
            Integer left = arr[i++];
            if (left != null) {
                poll.left = new TreeNode(left);
                queue.offer(poll.left);
            }
            if (i < arr.length) {
                Integer right = arr[i++];
                if (right != null) {
                    poll.right = new TreeNode(right);
                    queue.offer(poll.right);
                }
            }
        }
        return root;
    }

    public static List<Integer> treeToArr(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add(null);
//                queue.offer(null);
//                queue.offer(null);
                continue;
            }
            res.add(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return res;
    }
}
