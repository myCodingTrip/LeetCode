package contest.wc368.p1;

class Solution {
    public int minimumSum(int[] nums) {
        int length = nums.length;
        int res = -1;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (res == -1) {
                            res = sum;
                        } else {
                            res = Math.min(res, sum);
                        }
                    }
                }
            }
        }
        return res;
    }
}
