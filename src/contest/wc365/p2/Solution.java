package contest.wc365.p2;

class Solution {
    public long maximumTripletValue(int[] nums) {
        int length = nums.length;
        int[] iMax = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, nums[i]);
            iMax[i] = max;
        }
        int[] kMax = new int[length];
        max = 0;
        for (int i = length - 1; i > 0; i--) {
            max = Math.max(max, nums[i]);
            kMax[i] = max;
        }

        long res = 0;
        for (int i = 1; i < length - 1; i++) {
            res = Math.max(res, (long) (iMax[i - 1] - nums[i]) * kMax[i + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
    }
}
