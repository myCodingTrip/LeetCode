package problem.problem376;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //todo 27.12% list问题？
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int minus = nums[i] - nums[i - 1];
            if (minus != 0)
                list.add(minus);
        }
        if (list.size() == 0) return 1;
        //[0,i]的最长子序列
        int[] dp = new int[list.size()];
        dp[0] = 1;
        boolean positive = list.get(0) > 0;
        for (int i = 1; i < list.size(); i++) {
            Integer num = list.get(i);
            //异或判断
            if (positive ^ (num > 0)) {
                positive = !positive;
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[list.size() - 1] + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }
}
