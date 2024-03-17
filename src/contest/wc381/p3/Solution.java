package contest.wc381.p3;

import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        char[] chars = word.toCharArray();
        for (char c : chars) {
            arr[c - 'a']++;
        }
        Arrays.sort(arr);
        int res = 0, k = 0;
        for (int i = 25; i >= 0; i--) {
            if (arr[i] > 0) {
                res += arr[i] * ((k++ / 8) + 1);
            }
        }
        return res;
    }
}
