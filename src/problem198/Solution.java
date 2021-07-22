package problem198;

class Solution {
    public int rob(int[] nums) {
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

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2, 7, 9, 3, 1}));
    }
}