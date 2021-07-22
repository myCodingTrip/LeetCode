package problem167;

import java.util.Arrays;

class Solution {

    //二分查找
    //3ms
    public int[] twoSum0(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = find(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j != -1) {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    private int find(int[] numbers, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (numbers[mid] > target) {
            return find(numbers, low, mid - 1, target);
        } else if (numbers[mid] < target) {
            return find(numbers, mid + 1, high, target);
        } else {
            return mid;
        }
    }

    //对撞指针
    //1ms
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.twoSum(new int[]{5, 25, 75}, 100)));
        System.out.println(Arrays.toString(sol.twoSum(new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8)));
        ;
    }
}