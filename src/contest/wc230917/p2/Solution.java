package contest.wc230917.p2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    //time out
    public int countWaysTimeOut(List<Integer> nums) {
        int res = 0;
        Collections.sort(nums);
        int size = nums.size();
        for (int selected = 0; selected <= size; selected++) {
            boolean success = true;
            for (int j = 0; j < selected; j++) {
                if (selected <= nums.get(j)) {
                    success = false;
                    break;
                }
            }
            if (success) {
                for (int j = selected; j < size; j++) {
                    if (selected >= nums.get(j)) {
                        success = false;
                        break;
                    }
                }
            }
            if (success) {
                //System.out.println(nums + " " + i);
                res++;
            }
        }
        return res;
    }

    public int countWays(List<Integer> nums) {
        int res = 0;
        Collections.sort(nums);
        int size = nums.size();
        for (int selected = 0; selected <= size; selected++) {
            boolean success = true;
            int x = selected - 1;
            if (x >= 0 && selected <= nums.get(x)) {
                success = false;
                continue;
            }
            if (success) {
                if (selected < size && selected >= nums.get(selected)) {
                    success = false;
                    continue;
                }
            }
            if (success) {
                //System.out.println(nums + " " + selected);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countWays(Arrays.asList(6, 0, 3, 3, 6, 7, 2, 7)));
    }
}
