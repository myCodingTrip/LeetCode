package problem215;

import java.util.Arrays;
import java.util.Random;

class Solution {
    //nlogn
    public int findKthLargest0(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    //[low, high] 倒序快排
    private int findKthLargest(int[] nums, int low, int high, int k) {
        if (low == high) return nums[low];
        int p = partition(nums, low, high);
        if (k < p) {
            return findKthLargest(nums, low, p - 1, k);
        } else if (k > p) {
            return findKthLargest(nums, p + 1, high, k);
        } else {
            return nums[p];
        }
    }

    private int partition(int[] nums, int low, int high) {
        // 随机选轴防止极端情况
        int p = low + new Random().nextInt(high - low);
//        System.out.println(low + " " + high + " " + p);
        swapByTemp(nums, low, p);

        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && nums[right] <= nums[low])
                right--;
            while (left < right && nums[left] >= nums[low])
                left++;
            if (left < right)
                swapByTemp(nums, left, right);
        }
        swapByTemp(nums, left, low);
        return left;
    }

    public static void swapByTemp(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
        System.out.println(sol.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));//4
        System.out.println(sol.findKthLargest(new int[]{2, 1}, 2));//1
        System.out.println(sol.findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 2));//6
        System.out.println(sol.findKthLargest(new int[]{5, 2, 4, 1, 3, 6, 0}, 4));//3
    }
}