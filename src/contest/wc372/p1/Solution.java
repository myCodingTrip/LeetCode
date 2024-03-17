package contest.wc372.p1;

class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        if (s1.charAt(0) != s2.charAt(0) || s1.charAt(0) != s3.charAt(0)) {
            return -1;
        }
        int min = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int res = 0;
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) != s2.charAt(i) || s1.charAt(i) != s3.charAt(i)) {
                res += (min - i) * 3;
                break;
            }
        }
        return res + (s1.length() - min) + (s2.length() - min) + (s3.length() - min);
    }
}
