package contest.wc364.p2;

import java.util.Arrays;
import java.util.List;

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int size = maxHeights.size();

        long res = 0L;

        for (int topPos = 0; topPos < size; topPos++) {
            long tempRes = maxHeights.get(topPos);
            int[] arr = new int[size];
            arr[topPos] = maxHeights.get(topPos);
            for (int i = topPos + 1; i < size; i++) {
                arr[i] = Math.min(maxHeights.get(i), arr[i - 1]);
                tempRes += arr[i];
            }
            for (int i = topPos - 1; i >= 0; i--) {
                arr[i] = Math.min(maxHeights.get(i), arr[i + 1]);
                tempRes += arr[i];
            }
            //System.out.println(Arrays.toString(arr));
            res = Math.max(res, tempRes);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
    }
}
