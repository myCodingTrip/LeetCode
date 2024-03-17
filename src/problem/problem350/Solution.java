package problem.problem350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (Integer num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (Integer num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Integer num : map1.keySet()) {
            Integer count1 = map1.getOrDefault(num, 0);
            Integer count2 = map2.getOrDefault(num, 0);
            int count = Math.min(count1, count2);
            for (int i = 0; i < count; i++) {
                list.add(num);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
