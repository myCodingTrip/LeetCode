package contest.wc230813.p1;

class Solution {
    public int maxSum(int[] nums) {
        int res = -1;
        int length = nums.length;
        int[] maxNums = new int[length];
        for (int i = 0; i < length; i++) {
            maxNums[i] = getMaxNum(nums[i]);
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (maxNums[i] == maxNums[j]) {
                    res = Math.max(res, nums[i] + nums[j]);
                }
            }
        }
        return res;
    }

    private int getMaxNum(int num) {
        int max = 0;
        while (num > 0) {
            int i = num % 10;
            max = Math.max(max, i);
            num = num / 10;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSum(new int[]{51, 71, 17, 24, 42}));
    }
}
