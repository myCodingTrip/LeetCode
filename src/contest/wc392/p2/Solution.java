package contest.wc392.p2;

class Solution {
    public String getSmallestString(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (k == 0) {
                break;
            }
            int n = chars[i] - 'a';
            int min = Math.min(n, 25 - n + 1);
            if (min <= k) {
                chars[i] = 'a';
                k -= min;
            } else {
                chars[i] -= k;
                k = 0;
            }
        }
        return new String(chars);
    }
}
