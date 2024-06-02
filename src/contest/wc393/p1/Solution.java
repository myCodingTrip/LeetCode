package contest.wc393.p1;

class Solution {
    public String findLatestTime(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '?') {
            if (chars[1] == '0' || chars[1] == '1' || chars[1] == '?') {
                chars[0] = '1';
            } else {
                chars[0] = '0';
            }
        }
        if (chars[1] == '?') {
            if (chars[0] == '0') {
                chars[1] = '9';
            } else {
                chars[1] = '1';
            }
        }
        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }
        return new String(chars);
    }
}
