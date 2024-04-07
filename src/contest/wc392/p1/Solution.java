package contest.wc392.p1;

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 1;
        int i = 0, j = 1;
        int length = nums.length;
        while (j < length) {
            if (nums[j] < nums[j - 1]) {
                res = Math.max(res, j - i + 1);
            } else {
                i = j;
            }
            j++;
        }
        i = 0;
        j = 1;
        while (j < length) {
            if (nums[j] > nums[j - 1]) {
                res = Math.max(res, j - i + 1);
            } else {
                i = j;
            }
            j++;
        }
        return res;
    }
}
