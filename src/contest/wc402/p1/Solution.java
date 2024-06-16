package contest.wc402.p1;

class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int length = hours.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
