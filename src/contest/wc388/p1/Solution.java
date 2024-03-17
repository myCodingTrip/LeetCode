package contest.wc388.p1;

import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;
        for (int i : apple) {
            sum += i;
        }
        int res = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            sum -= capacity[i];
            res++;
            if (sum <= 0) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumBoxes(new int[]{1, 3, 2}, new int[]{4, 3, 1, 5, 2}));
    }
}
