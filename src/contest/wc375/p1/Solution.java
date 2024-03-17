package contest.wc375.p1;

class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;
        int length = batteryPercentages.length;
        for (int i = 0; i < length; i++) {
            if (batteryPercentages[i] > 0) {
                res++;
                for (int j = i + 1; j < length; j++) {
                    batteryPercentages[j] = Math.max(batteryPercentages[j] - 1, 0);
                }
            }
        }
        return res;
    }
}
