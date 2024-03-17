package contest.wc381.p2;

import java.util.Arrays;

class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        if (x > y) {
            int t = x;
            x = y;
            y = t;
        }
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int dis;
                if (j == i + 1) {
                    dis = 1;
                } else if (i <= x && j >= y && x != y) {
                    dis = (x - i) + (j - y) + 1;
                } else {
                    dis = Math.min(j - i, Math.abs(x - i) + Math.abs(j - y) + 1);
                }
                res[dis - 1]++;
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countOfPairs(5, 1, 5)));
    }
}
