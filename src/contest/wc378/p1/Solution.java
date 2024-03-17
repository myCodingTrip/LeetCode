package contest.wc378.p1;

class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                if (++count == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
