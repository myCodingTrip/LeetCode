package problem75;

import java.util.Arrays;

class Solution {
    public void sortColors0(int[] nums) {
        Arrays.sort(nums);
    }

    //计数排序
    //time o(n) space o(1) 数组遍历2次
    public void sortColors1(int[] nums) {
        int[] arr = new int[3];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                nums[index++] = i;
                arr[i]--;
            }
        }
    }

    //三路快排
    //time o(n) space o(1) 只遍历了一次
    public void sortColors(int[] nums) {
        int zero = -1;  //[0,zero]
        int two = nums.length;  //[two,length-1]
        for (int i = 0; i < two; ) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 2) {
                two--;
                swapByTemp(nums, i, two);
            } else {//nums[i]==0
                zero++;//此时nums[zero]==1
                swapByTemp(nums, i, zero);
                i++;
            }
        }
    }

    public static void swapByTemp(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}