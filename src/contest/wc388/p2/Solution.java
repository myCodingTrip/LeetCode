package contest.wc388.p2;

import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        Arrays.sort(happiness);
        int n = happiness.length;
        for (int i = 0; i < k; i++) {
            res += Math.max(0, happiness[n - 1 - i] - i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumHappinessSum(new int[]{1, 1, 1, 1}, 2));
        System.out.println(new Solution().maximumHappinessSum(new int[]{2, 3, 4, 5}, 1));
    }
}
