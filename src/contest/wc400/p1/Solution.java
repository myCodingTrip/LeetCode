package contest.wc400.p1;

class Solution {
    public int minimumChairs(String s) {
        int res = 0;
        int count = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == 'E') {
                count++;
            } else {
                count--;
                //if (count < 0) count = 0;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
