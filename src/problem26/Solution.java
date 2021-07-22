package problem26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != max) {
                nums[i++] = nums[j];
                max = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums;
        int c;

        nums = new int[]{1, 1, 2};
        c = sol.removeDuplicates(nums);
        print(nums, c);
    }

    private static void print(int[] num, int c) {
        for (int i = 0; i < c; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}