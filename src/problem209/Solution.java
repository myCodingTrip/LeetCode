package problem209;

//滑动窗口
//通过调整窗口大小找一个最小的窗口
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int minLen = nums.length + 1;
        int sum = nums[0];
        int i = 0, j = 0;
        while (true) {
            if (sum < s) {
                j++;
                if (j == nums.length) break;
                sum += nums[j];
            } else if (sum >= s) {
                int len = j - i + 1;
                if (len < minLen) minLen = len;
                if (minLen == 1) return 1;
                sum -= nums[i];
                i++;
                if (i == nums.length) break;
            }
        }
        if (minLen == nums.length + 1) return 0;
        else return minLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}