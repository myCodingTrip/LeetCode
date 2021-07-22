package problem377;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //依次算出[0, target]的组合的个数
        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j >= num && dp[j - num] > 0) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}