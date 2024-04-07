package contest.wc390.p2;

class Solution {
    public int minOperations(int k) {
        int low = 0, high = 5000;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxSum = getMaxSum(mid);
            int maxSum2 = getMaxSum(mid + 1);
            if (k > maxSum) {
                if (maxSum2 > k) {
                    return mid + 1;
                }
                low = mid;
            } else if (k < maxSum) {
                high = mid;
            } else {
                return mid;
            }
        }
        return high;
    }

    private int getMaxSum(int op) {
        if (op == 0) return 1;
        int maxSum = 0;
        int n = 0;
        while (n < op) {
            int sum = (2 + n) * (op - n);
            maxSum = Math.max(maxSum, sum);
            n++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(11));
        System.out.println(new Solution().minOperations(1));
    }
}
