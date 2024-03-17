package contest.wc380.p3;

class Solution {
    public long findMaximumNumber(long k, int x) {
        long l = 0L, r = Long.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(mid + 1, k, x)) {
                l = mid + 1;
            } else if (!check(mid, k, x)) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    private boolean check(long num, long k, int x) {
        long cnt = getCnt(num, k, x);
        return cnt <= k;
    }

    private long getCnt(long num, long k, int x) {
        long cnt = 0, half;
        for (long pow = 1L << x; (half = pow >> 1) <= num && cnt <= k; pow <<= x) {
            long l1 = (num + 1) / pow * half;
            long l2 = Math.max(0, (num + 1) % pow - half);
            cnt += l1 + l2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().getCnt(11, 20, 1));
        System.out.println(new Solution().getCnt(851568447023L, 3278539330613L, 5));
    }
}
