package weeklycontest230813.p3;

import java.util.List;

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int res = Integer.MAX_VALUE;
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + x; j < size; j++) {
                Integer i1 = nums.get(i);
                Integer i2 = nums.get(j);
                res = Math.min(res, Math.abs(i1 - i2));
                if (res == 0) {
                    return 0;
                }
            }
        }
        return res;
    }
}
