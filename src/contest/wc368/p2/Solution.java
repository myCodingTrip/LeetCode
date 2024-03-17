package contest.wc368.p2;

class Solution {
    public int minimumSum(int[] nums) {
        int length = nums.length;
        int[] leftArr = new int[length];
        int min = nums[0];
        leftArr[0] = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] > min) {
                leftArr[i] = min;
            } else {
                leftArr[i] = 0;
                min = nums[i];
            }
        }

        int res = -1;
        int[] rightArr = new int[length];
        min = nums[length - 1];
        rightArr[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] > min) {
                rightArr[i] = min;
                if (leftArr[i] != 0 && rightArr[i] != 0) {
                    int temp = leftArr[i] + rightArr[i] + nums[i];
                    if (res == -1) {
                        res = temp;
                    } else {
                        res = Math.min(res, temp);
                    }
                }
            } else {
                rightArr[i] = 0;
                min = nums[i];
            }
        }
        return res;
    }
}
