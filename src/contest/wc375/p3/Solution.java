package contest.wc375.p3;

class Solution {
    //暴力 超时
    public long countSubarraysTimeout(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int length = nums.length;
        int res = 0;
        int baseCount = 0;
        for (int right = 0; right < length; right++) {
            if (nums[right] == max) baseCount++;
            int count = baseCount;
            for (int left = 0; left <= right; left++) {
                if (count < k) {
                    break;
                }
                res++;
                if (nums[left] == max) count--;
            }
        }
        return res;
    }

    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int length = nums.length;
        long res = 0;
        int left = 0, count = 0;
        for (int right = 0; right < length; right++) {
            if (nums[right] == max) count++;
            while (count == k) {
                if (nums[left++] == max) count--;
            }
            res += left;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubarrays(new int[]{37, 20, 38, 66, 34, 38, 9, 41, 1, 14, 25, 63, 8, 12, 66, 66, 60, 12, 35, 27, 16, 38, 12, 66, 38, 36, 59, 54, 66, 54, 66, 48, 59, 66, 34, 11, 50, 66, 42, 51, 53, 66, 31, 24, 66, 44, 66, 1, 66, 66, 29, 54}, 5));
    }
}
