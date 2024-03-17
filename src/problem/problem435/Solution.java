package problem.problem435;

import java.util.Arrays;

//todo 5.01%
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if (length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            int[] intervalI = intervals[i];
            for (int j = 0; j < i; j++) {
                int[] intervalJ = intervals[j];
                if (intervalJ[1] <= intervalI[0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }
        return length - res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
