package contest.wc389.p2;

class Solution {
    public long countSubstrings(String s, char c) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (charArray[i] == c) {
                count++;
            }
        }
        if (count == 0 || count == 1) return count;
        return calculateCombination(count, 2) + count;
    }

    //dp求组合数（大数据范围）
    public long calculateCombination(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];

        // 初始化边界条件
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 计算组合数量
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][k];
    }

    //dfs求组合数
    public int calculateCombination0(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return calculateCombination0(n - 1, k - 1) + calculateCombination0(n - 1, k);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("abada", 'a'));
    }
}
