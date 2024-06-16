package contest.wc402.p2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        long count = 0;

        for (int hour : hours) {
            int rem = hour % 24;
            int target = (24 - rem) % 24;  // 找到与当前余数配对的余数

            if (remainderCount.containsKey(target)) {
                count += remainderCount.get(target);
            }

            // 更新哈希表中当前余数的计数
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
