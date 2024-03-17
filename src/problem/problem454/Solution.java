package problem.problem454;

import java.util.HashMap;
import java.util.Map;

/**
 * n^4==>n^2    将组合逻辑写入查找表  要查找什么是最重要的
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = C[i] + D[j];
                int count = countMap.getOrDefault(sum, 0);
                countMap.put(sum, count + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = A[i] + B[j];
                int count = countMap.getOrDefault(-sum, 0);
                if (count > 0) {
                    res += count;
                }
            }
        }
        return res;
    }
}
