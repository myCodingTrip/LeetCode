package contest.wc383.p2;

class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int length = word.length();
        int[] nextArr = getNextArr(word.toCharArray());
        int same = nextArr[length];
        int x = length - same;
        int res;
        if (x > k) {
            res = x / k;
            if (x % k > 0) {
                res++;
            }
        } else {
            return 1;
        }
        return res;
    }

    private int[] getNextArr(char[] str2) {
        if (str2.length == 1) {
            return new int[]{-1, 0};
        }
        int[] next = new int[str2.length + 1];
        next[0] = -1;
        next[1] = 0;
        int i = 2, cn = 0;
        while (i <= str2.length) {
            if (str2[i - 1] == str2[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
