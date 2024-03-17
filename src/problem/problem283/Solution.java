package problem.problem283;

class Solution {
    public void moveZeroes(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                res[i++] = num;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            nums[j] = res[j];
        }
    }

    /**
     * 不使用辅助空间
     * 不断优化
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
