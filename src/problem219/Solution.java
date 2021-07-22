package problem219;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k > nums.length - 1) k = nums.length - 1;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        for (int i = k + 1; i < nums.length; i++) {
            set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }
}