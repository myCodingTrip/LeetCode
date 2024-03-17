package contest.wc372.p2;

class Solution {
    public long minimumSteps(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int res = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char t = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = t;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSteps("101"));
    }
}
