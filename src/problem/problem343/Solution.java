package problem.problem343;

class Solution {
    public int integerBreak(int n) {
        //保存[2,n]乘积最大值
        int[] dp = new int[n + 1];
        dp[2] = 1;//1*1
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(10));
    }
}
