package problem.problem474;

import java.util.Arrays;

//这道题和经典的背包问题很类似，不同的是在背包问题中，我们只有一种容量，而在这道题中，我们有 0 和 1 两种容量。
//每个物品（字符串）需要分别占用 0 和 1 的若干容量，并且所有物品的价值均为 1。因此我们可以使用二维的动态规划。
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp: 使用i个0和j个1所能凑成的字符串数量
        int[][] dp = new int[m + 1][n + 1];
        print(dp);
        for (String str : strs) {
            System.out.println(str);
            //0的数量
            int strNum0 = 0;
            //1的数量
            int strNum1 = 0;
            //算出0和1的个数
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    strNum0++;
                } else if (c == '1') {
                    strNum1++;
                }
            }
            //不能顺序执行 会让结果变大
            for (int num0 = m; num0 >= strNum0; num0--) {
                for (int num1 = n; num1 >= strNum1; num1--) {
                    if (num0 >= strNum0 && num1 >= strNum1) {
                        //使用这个字符串和不使用这个字符串的最大值
                        dp[num0][num1] = Math.max(dp[num0 - strNum0][num1 - strNum1] + 1, dp[num0][num1]);
                    }
                }
            }
            print(dp);
        }
        return dp[m][n];
    }

    private void print(int[][] dp) {
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxForm(
                new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
