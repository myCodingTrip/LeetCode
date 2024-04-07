package contest.wc392.p3;

import java.util.Arrays;

class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long res = 0;
        int length = nums.length;
        int median = 0;
        int index;
        Arrays.sort(nums);
        index = length / 2;
        median = nums[index];
        if (median > k) {
            for (int i = index; i >= 0 && nums[i] > k; i--) {
                res += nums[i] - k;
            }
        } else if (median < k) {
            for (int i = index; i < length && nums[i] < k; i++) {
                res += k - nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 4));
        System.out.println(new Solution().minOperationsToMakeMedianK(new int[]{2, 68, 15, 39, 30, 39, 97, 68}, 2));
    }
}
