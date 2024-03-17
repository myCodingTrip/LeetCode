package contest.wc371.p1;

class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int length = nums.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int num1 = nums[i];
                int num2 = nums[j];
                if (Math.abs(num1 - num2) <= Math.min(num1, num2)) {
                    res = Math.max(res, num1 ^ num2);
                }
            }
        }
        return res;
    }
}
