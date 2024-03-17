package contest.wc380.p1;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxCount = 0;
        int[] arr = new int[101];
        for (int i : nums) {
            arr[i]++;
            maxCount = Math.max(maxCount, arr[i]);
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == maxCount) {
                res += maxCount;
            }
        }
        return res;
    }
}
