package contest.wc366.p3;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minOperations(String s1, String s2, int x) {
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }
        }
        int size = diff.size();
        if (size == 0) return 0;
        if (size % 2 > 0) {
            return -1;
        }
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i - 1] + x,
                        i > 1 ? dp[i - 2] + (diff.get(i) - diff.get(i - 1)) * 2 : (diff.get(1) - diff.get(0)) * 2);
            } else {
                dp[i] = x;
            }
        }
        return dp[size - 1] / 2;
    }
}
