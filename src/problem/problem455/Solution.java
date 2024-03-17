package problem.problem455;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int sIndex = s.length - 1;
        int res = 0;

        for (int i = g.length - 1; i >= 0; i--) {
            if (sIndex >= 0 && s[sIndex] >= g[i]) {
                res++;
                sIndex--;
            }
        }

        return res;
    }
}
