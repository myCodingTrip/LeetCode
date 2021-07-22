package problem450;

import common.TreeNode;
import common.TreeUtil;

//算法：
//
//        如果 key > root.val，说明要删除的节点在右子树，root.right = deleteNode(root.right, key)。
//        如果 key < root.val，说明要删除的节点在左子树，root.left = deleteNode(root.left, key)。
//        如果 key == root.val，则该节点就是我们要删除的节点，则：
//        如果该节点是叶子节点，则直接删除它：root = null。
//        如果该节点不是叶子节点且有右节点，则用它的后继节点的值替代 root.val = successor.val，然后删除后继节点。
//        如果该节点不是叶子节点且只有左节点，则用它的前驱节点的值替代 root.val = predecessor.val，然后删除前驱节点。
//        返回 root。
class Solution {

    //    0ms 100%
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            if (root.val == key) {
                return null;
            } else return root;
        }
        deleteNode(null, root, key, false);
        return root;
    }

    private void deleteNode(TreeNode pre, TreeNode node, int key, boolean left) {
        if (key > node.val && node.right != null) {
            deleteNode(node, node.right, key, false);
        } else if (key < node.val && node.left != null) {
            deleteNode(node, node.left, key, true);
        } else if (key == node.val) {
            //要删除的是叶子节点
            if (node.left == null && node.right == null) {
                if (left) {
                    pre.left = null;
                } else {
                    pre.right = null;
                }
            }//要删除的节点只有左孩子
            else if (node.left != null && node.right == null) {
                node.val = removeMax(node, node.left);
            }//要删除的节点有右孩子
            else {
                node.val = removeMin(node, node.right);
            }
        }
    }

    /**
     * 移除并返回树的最小值
     *
     * @param pre
     * @param node
     * @return
     */
    private int removeMin(TreeNode pre, TreeNode node) {
        while (node.left != null) {
            pre = node;
            node = node.left;
        }
        return remove(pre, node);
    }

    /**
     * 移除并返回树的最大值
     *
     * @param pre
     * @param node
     * @return
     */
    private int removeMax(TreeNode pre, TreeNode node) {
        while (node.right != null) {
            pre = node;
            node = node.right;
        }
        return remove(pre, node);
    }

    private int remove(TreeNode pre, TreeNode node) {
        int val = node.val;
        if (pre.left != null && pre.left.val == node.val) {
            deleteNode(pre, node, node.val, true);
        } else if (pre.right != null && pre.right.val == node.val) {
            deleteNode(pre, node, node.val, false);
        }
        return val;
    }

    public static void main(String[] args) {
//        TreeNode root = new Solution().deleteNode(
//                TreeUtil.arrToTree(new Integer[]{5, 3, 7, 2, null, 6, 8}), 6);
//        TreeNode root2 = new Solution().deleteNode(
//                TreeUtil.arrToTree(new Integer[]{5, 3, 7, 2, null, 6, 8}), 3);
//        TreeNode root3 = new Solution().deleteNode(
//                TreeUtil.arrToTree(new Integer[]{5, 3, 7, 2, null, 6, 8}), 7);
//        System.out.println(TreeUtil.treeToArr(root));
//        System.out.println(TreeUtil.treeToArr(root2));
//        System.out.println(TreeUtil.treeToArr(root3));

        System.out.println(TreeUtil.treeToArr(new Solution().deleteNode(
                TreeUtil.arrToTree(new Integer[]{27, 17, 33, 15, 26, 32, 45, 7, 16, 23, null, 31, null, 40, 49, 5, 14, null, null, 21, 25, 29, null, 34, 41, 48, null, 2, 6, 10, null, 20, 22, 24, null, 28, 30, null, 39, null, 42, 46, null, 1, 4, null, null, 9, 11, 18, null, null, null, null, null, null, null, null, null, 37, null, null, 44, null, 47, 0, null, 3, null, 8, null, null, 13, null, 19, 35, 38, 43, null, null, null, null, null, null, null, null, null, 12, null, null, null, null, 36}), 49)));
    }
}