package contest.wc366.p1;

class Solution {
    public int differenceOfSums(int n, int m) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int i1 = i % m;
            if (i1 > 0) {
                res += i;
            } else {
                res -= i;
            }
        }
        return res;
    }
}
