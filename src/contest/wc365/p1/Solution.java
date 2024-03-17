package contest.wc365.p1;

class Solution {
    public long maximumTripletValue(int[] nums) {
        int length = nums.length;
        long res = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    long temp = (long) (nums[i] - nums[j]) * nums[k];
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTripletValue(new int[]{8, 6, 3, 13, 2, 12, 19, 5, 19, 6, 10, 11, 9}));
    }
}
