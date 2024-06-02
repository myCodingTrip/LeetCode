package contest.wc393.p2;

class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                end = i;
                if (start == -1) {
                    start = i;
                }
            }
        }
        return end - start;
    }

    //判断一个数是否是素数
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
