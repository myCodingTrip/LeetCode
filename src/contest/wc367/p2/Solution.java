package contest.wc367.p2;

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int oneNum = 0;
        int length = s.length();
        int i = 0, j = 0;
        if (s.charAt(0) == '1') {
            oneNum++;
        }
        while (i < length && j < length) {
            if (s.charAt(i) == '0') {
                i++;
            } else if (oneNum == k) {
                if ("".equals(res) || j - i + 1 <= res.length()) {
                    String substring = s.substring(i, j + 1);
                    if ("".equals(res) || j - i + 1 < res.length() || substring.compareTo(res) < 0) {
                        res = substring;
                    }
                }
                oneNum--;
                i++;
            } else if (oneNum < k) {
                j++;
                if (j < length && s.charAt(j) == '1') {
                    oneNum++;
                }
            } else {
                oneNum--;
                i++;
            }
            if (j < i) {
                j++;
                if (j < length && s.charAt(j) == '1') {
                    oneNum++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestBeautifulSubstring("100011001", 3));
    }
}
