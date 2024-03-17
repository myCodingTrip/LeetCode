package contest.wc376.p2;

import java.util.Arrays;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int count = length / 3;
        int[][] res = new int[count][3];
        for (int i = 0; i < count; i++) {
            int index = i * 3;
            int diff1 = nums[index + 2] - nums[index];
            if (diff1 > k) {
                return new int[][]{};
            }
            res[i] = new int[]{nums[index], nums[index + 1], nums[index + 2]};
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().divideArray(
                new int[]{15, 13, 12, 13, 12, 14, 12, 2, 3, 13, 12, 14, 14, 13, 5, 12, 12, 2, 13, 2, 2}, 2)));
    }
}
