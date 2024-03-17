package problem.knapsack;

public class Solution {

    //记忆数组
    int[][] cache;

    /**
     * @param w 重量数组
     * @param v 价值数组
     * @param C 总体积
     * @return
     */
    public int knapsack(int[] w, int[] v, int C) {
        int n = w.length;
        cache = new int[n][C + 1];
        return dfs(w, v, C, n - 1);
    }

    /**
     * 使用回溯法+记忆数组
     *
     * @param w 重量数组
     * @param v 价值数组
     * @param c 剩余体积
     * @param i 使用物品[0,i]解决这个问题
     * @return
     */
    private int dfs(int[] w, int[] v, int c, int i) {
        if (i <= 0 || c <= 0) return 0;
        if (cache[i][c] > 0) {
            return cache[i][c];
        }
        int res = dfs(w, v, c, i - 1);
        //可以装得下
        if (w[i] <= c) {
            res = Math.max(res, v[i] + dfs(w, v, c - w[i], i - 1));
        }
        cache[i][c] = res;
        return res;
    }

    /**
     * 使用动态规划
     *
     * @param w
     * @param v
     * @param C
     * @return
     */
    public int knapsackDp(int[] w, int[] v, int C) {
        int n = w.length;
        //优化空间复杂度 n*C->2*C
        int[][] dp = new int[1][C + 1];
        for (int i = 1; i < n; i++) {
            int i1 = i % 2;
            int i2 = (i - 1) % 2;
            for (int j = 0; j <= C; j++) {
                dp[i1][j] = dp[i2][j];
                if (j > w[i]) {
                    dp[i1][j] = Math.max(dp[i1][j], v[i] + dp[i2][j - w[i]]);
                }
            }

//            for (int j = 0; j < C; j++) {
//                System.out.treeToArr(dp[i1][j]+" ");
//            }
//            System.out.println();
        }
//        System.out.println(dp);
        return dp[(n - 1) % 2][C];
    }

    /**
     * 空间复杂度极简动态规划
     *
     * @param w
     * @param v
     * @param C
     * @return
     */
    public int knapsackDp2(int[] w, int[] v, int C) {
        int n = w.length;
        //优化空间复杂度 2*C->C 代码也更少了
        int[] dp = new int[C + 1];
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= 0; j--) {
                if (j > w[i])
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        //133
//        System.out.println(new Solution().knapsack(new int[]{77, 22, 29, 50, 99},
//                new int[]{92, 22, 87, 46, 90}, 100));
        System.out.println(new Solution().knapsackDp2(new int[]{77, 22, 29, 50, 99},
                new int[]{92, 22, 87, 46, 90}, 100));
    }
}
