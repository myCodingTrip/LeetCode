package problem.problem322;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        //存储凑齐某一数额的钱需要的最少硬币数量
        int[] minCoinNums = new int[amount + 1];
        //0元可以凑齐
        //-1表示不能凑齐
        Arrays.fill(minCoinNums, -1);
        //0元不需要硬币
        minCoinNums[0] = 0;
        //遍历数额
        for (int need = 1; need <= amount; need++) {
            //遍历硬币
            for (int coinVal : coins) {
                //硬币价值不超过所需数额并且加上这枚硬币就能凑齐当前数额
                if (need >= coinVal && minCoinNums[need - coinVal] != -1) {
                    //判断以前的方案和本次方案哪个用的硬币更少
                    minCoinNums[need] = getMinCoinNum(minCoinNums[need], minCoinNums[need - coinVal] + 1);
                }
            }
        }
        return minCoinNums[amount];
    }

    /**
     * 获取较小值（-1表示无值）
     *
     * @param v1
     * @param v2
     * @return
     */
    private int getMinCoinNum(int v1, int v2) {
        if (v1 == -1) {
            return v2;
        } else {
            return Math.min(v1, v2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(
                new int[]{1, 2, 5}, 11));
    }
}
