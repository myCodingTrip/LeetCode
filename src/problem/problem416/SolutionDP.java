package problem.problem416;

//和背包问题不同：不需要考虑价值，但是要完全填满
//F（）
class SolutionDP {
    public boolean canPartition(int[] nums) {

        //先算出目标：数组和的一半
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        //dp[i]表示是否可以从数组中拿出几个元素，和为i
        boolean[] dp = new boolean[target + 1];
        //0满足要求（不设置也可以）
        dp[0] = true;

        //只考虑第一个物品
        for (int i = 0; i <= target; i++) {
            if (i == nums[0]) {
                dp[i] = true;
                break;
            }
        }

        //从第二个物品开始计算
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || (dp[j - nums[i]]);
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new SolutionDP().canPartition(new int[]{1, 5, 11, 5}));
    }
}
