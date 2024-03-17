package problem.problem309;

import java.util.Arrays;

//0 表示不持股；
//1 表示持股；
//2 表示处在冷冻期。
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int length = prices.length;
        int[][] dp = new int[length][3];
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            //什么都不做与卖掉股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            //买这支股票与买前面的股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //卖掉这支股票
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        for (int i = 0; i < length; i++)
            System.out.println(Arrays.toString(dp[i]));
        return Math.max(dp[length - 1][0], dp[length - 1][2]);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(new Solution().maxProfit(new int[]{4, 2, 1}));
    }
}
