package problem.problem222;

import common.TreeNode;
import common.TreeUtil;

public class Compare {
    //一千万节点时间 64:1
    public static void main(String[] args) {
        Integer[] arr = new Integer[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        TreeNode root = TreeUtil.arrToTree(arr);
        long t1 = System.currentTimeMillis();
        new Solution().countNodes(root);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        new Solution3().countNodes(root);
        long t3 = System.currentTimeMillis();
        System.out.println(t3 - t2);
    }
}
