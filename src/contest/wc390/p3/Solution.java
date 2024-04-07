package contest.wc390.p3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public long[] mostFrequentIDsTimeOut(int[] nums, int[] freq) {
        int length = nums.length;
        long[] res = new long[length];
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Long aLong = map.getOrDefault(nums[i], 0L);
            map.put(nums[i], Math.max(aLong + freq[i], 0));
            if (i > 0 && aLong > res[i - 1]) {
                res[i] = aLong;
            } else {
                for (Integer num : map.keySet()) {
                    res[i] = Math.max(res[i], map.get(num));
                }
            }
        }
        return res;
    }

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int length = nums.length;
        long[] res = new long[length];
        Map<Integer, Long> kvMap = new HashMap<>();
        Map<Long, Integer> vkMap = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            Long aLong = Math.max(kvMap.getOrDefault(nums[i], 0L) + freq[i], 0);
            if (aLong > 0) {
                kvMap.put(nums[i], aLong);
            }


        }
        return res;
    }

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        //If the specified key is not already associated关联 with a value or is associated with null, associates it with the given non-null value.
        //Otherwise, replaces the associated value with the results of the given remapping function, or removes if the result is null.
        //This method may be of use when combining multiple mapped values for a key.
        //For example, to either create or append a String msg to a value mapping:map.merge(key, msg, String::concat)
        // 使用merge()方法添加新值或合并已有值
        treeMap.merge("key1", 1, Integer::sum); // 如果key1不存在，则将1关联到key1上；否则将1与已存在的值进行求和操作
        treeMap.merge("key2", 2, Integer::sum); // 如果key2不存在，则将2关联到key2上；否则将2与已存在的值进行求和操作
        treeMap.merge("key1", 3, Integer::sum); // 将3与已存在的值进行求和操作

        System.out.println(treeMap); // 输出：{key1=4, key2=2}
    }
}
