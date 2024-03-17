package problem.problem257;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> leftList = binaryTreePaths(root.left);
        for (String path : leftList) {
            res.add(root.val + "->" + path);
        }
        List<String> rightList = binaryTreePaths(root.right);
        for (String path : rightList) {
            res.add(root.val + "->" + path);
        }
        return res;
    }
}
