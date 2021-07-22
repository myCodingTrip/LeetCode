package problem1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //45ms
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //5ms
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer v = map.get(target - nums[i]);
            if (v == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{v, i};
            }

        }
        return null;
    }
}