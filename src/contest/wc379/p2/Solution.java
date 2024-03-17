package contest.wc379.p2;

class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e && (a != c || !isInside(d, b, f))) {
            return 1;
        } else if (b == f && (b != d || !isInside(c, a, e))) {
            return 1;
        } else if (c - d == e - f && ((a - b != e - f) ||
                !(isInside(a, c, e) && isInside(b, d, f)))) {
            return 1;
        } else if (c + d == e + f && ((a + b != e + f) ||
                !(isInside(a, c, e) && isInside(b, d, f)))) {
            return 1;
        }
        return 2;
    }

    private boolean isInside(int d, int d1, int d2) {
        return d > Math.min(d1, d2) && d < Math.max(d1, d2);
    }
}
