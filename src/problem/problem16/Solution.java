package problem.problem16;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        ;
    }

    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
//        if (nums == null && nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    int num = sum - target;
                    if (Math.abs(num) < Math.abs(min))
                        min = num;
                    left++;
                } else if (sum > target) {
                    int num = sum - target;
                    if (Math.abs(num) < Math.abs(min))
                        min = num;
                    right--;
                }
            }
        }
        return target + min;
    }
}
