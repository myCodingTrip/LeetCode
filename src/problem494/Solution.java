package problem494;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0);
    }

    private int dfs(int[] nums, int S, int start) {
        if (start == nums.length) {
            if (S == 0) return 1;
            return 0;
        }
        return dfs(nums, S + nums[start], start + 1) + dfs(nums, S - nums[start], start + 1);
    }
}