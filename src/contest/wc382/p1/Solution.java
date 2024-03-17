package contest.wc382.p1;

class Solution {
    public int countKeyChanges(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)
                    && s.charAt(i) + 32 != s.charAt(i + 1)
                    && s.charAt(i) - 32 != s.charAt(i + 1)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countKeyChanges("aAbBcC"));
    }
}
