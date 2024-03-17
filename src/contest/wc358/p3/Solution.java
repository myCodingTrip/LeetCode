package contest.wc358.p3;

import java.util.List;
import java.util.TreeSet;

class Solution {
    public int minAbsoluteDifferenceTimeOut(List<Integer> nums, int x) {
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

    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int res = Integer.MAX_VALUE;
        int size = nums.size();
        TreeSet<Integer> set = new TreeSet<>();
        set.add(Integer.MAX_VALUE);
        set.add(-Integer.MAX_VALUE / 2);
        for (int i = x; i < size; i++) {
            set.add(nums.get(i - x));
            Integer y = nums.get(i);
            res = Math.min(res, Math.min(y - set.floor(y), set.ceiling(y) - y));
        }
        return res;
    }
}
