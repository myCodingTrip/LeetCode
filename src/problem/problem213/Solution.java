package problem.problem213;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(rob0(Arrays.copyOfRange(nums, 0, n - 1))
                , rob0(Arrays.copyOfRange(nums, 1, n)));
    }

    /**
     * 按不成环进行计算
     *
     * @param nums
     * @return
     */
    private int rob0(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            //偷i和不偷i两种情况
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }
}
