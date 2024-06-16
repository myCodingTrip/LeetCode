package contest.wc402.p3;

import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < power.length; i++) {
            map.merge(power[i], 1, Integer::sum);
        }
        long[] dp = new long[map.size()];
        Set<Integer> keySet = map.keySet();
        List<Integer> list = new ArrayList<>(keySet);
        dp[0] = (long) list.get(0) * map.get(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            Integer key = list.get(i);
            long temp = (long) key * map.get(key);
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j) < key - 2) {
                    temp += dp[j];
                    break;
                }
            }
            dp[i] = Math.max(dp[i - 1], temp);
        }
        return dp[list.size() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTotalDamage(new int[]{7, 1, 6, 3}));
    }
}
