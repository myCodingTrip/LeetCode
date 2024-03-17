package contest.wc389.p1;

class Solution {
    public boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reverse = sb.toString();
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            String substring = s.substring(i, i + 2);
            if (reverse.contains(substring)) {
                return true;
            }
        }
        return false;
    }
}
