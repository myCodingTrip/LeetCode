package contest.wc382.p2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        int oneNum = 0;
        for (int num : nums) {
            if (num == 1) {
                oneNum++;
            }
            int count = map.getOrDefault(num, 0);
            if (count == 2) {
                continue;
            }
            map.put(num, count + 1);
        }
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (Integer num : map.keySet()) {
            if (num == 1) {
                continue;
            }
            if (set.contains(num)) {
                continue;
            }
            int count = map.get(num);
            set.add(num);
            int temp = 0;
            while (count > 1) {
                temp += 2;
                num = num * num;
                set.add(num);
                Integer c = map.get(num);
                if (c == null) {
                    temp--;
                    res = Math.max(res, temp);
                    break;
                } else if (c == 1) {
                    temp++;
                    res = Math.max(res, temp);
                    break;
                }
                count = c;
            }
        }
        res = Math.max(res, oneNum % 2 == 1 ? oneNum : oneNum - 1);
        return res;
    }

    public static void main(String[] args) {
        assert new Solution().maximumLength(new int[]{5, 4, 1, 2, 2}) == 3;
        assert new Solution().maximumLength(new int[]{5, 4, 1, 2, 2, 4}) == 3;
        assert new Solution().maximumLength(new int[]{1, 3, 2, 4}) == 1;
        System.out.println(new Solution().maximumLength(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}));
    }
}
