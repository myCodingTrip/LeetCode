package contest.wc367.p3;

class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int length = nums.length;

        int[] minIndexArr = new int[length];
        minIndexArr[length - 1] = length - 1;
        int[] maxIndexArr = new int[length];
        maxIndexArr[length - 1] = length - 1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[minIndexArr[i + 1]]) {
                minIndexArr[i] = i;
            } else {
                minIndexArr[i] = minIndexArr[i + 1];
            }
            if (nums[i] > nums[maxIndexArr[i + 1]]) {
                maxIndexArr[i] = i;
            } else {
                maxIndexArr[i] = maxIndexArr[i + 1];
            }
        }

        for (int i = 0; i < length - indexDifference; i++) {
            if (Math.abs(nums[i] - nums[minIndexArr[i + indexDifference]]) >= valueDifference) {
                return new int[]{i, minIndexArr[i + indexDifference]};
            }
            if (Math.abs(nums[i] - nums[maxIndexArr[i + indexDifference]]) >= valueDifference) {
                return new int[]{i, maxIndexArr[i + indexDifference]};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findIndices(new int[]{5, 1, 4, 1}, 2, 4));
    }
}
