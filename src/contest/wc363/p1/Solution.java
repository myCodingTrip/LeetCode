package contest.wc363.p1;

import java.util.List;

class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int size = nums.size();
        int res = 0;
        for (int i = 0; i < size; i++) {
            String binaryString = Integer.toBinaryString(i);
            char[] chars = binaryString.toCharArray();
            int count = 0;
            for (char c : chars) {
                if (c == '1') {
                    count++;
                }
            }
            if (count == k) {
                res += nums.get(i);
            }
        }
        return res;
    }
}
