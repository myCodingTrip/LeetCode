package contest.wc381.p1;

class Solution {
    public int minimumPushes(String word) {
        int length = word.length();
        int res = 0, i = 1;
        while (length >= 8) {
            res += 8 * i++;
            length -= 8;
        }
        res += length * i;
        return res;
    }
}
