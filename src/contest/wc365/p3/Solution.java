package contest.wc365.p3;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int res = -1;
        List<Integer> infiniteNums = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int devide = target / sum;
        for (int i = 0; i < devide + 2; i++) {
            for (int num : nums) {
                infiniteNums.add(num);
            }
        }
        int size = infiniteNums.size();
        int i = 0, j = 0;
        target -= infiniteNums.get(0);
        while (j < size) {
            //System.out.println(i + " " + j + " " + target);
            if (target == 0) {
                if (res == -1) {
                    res = j - i + 1;
                } else {
                    res = Math.min(res, j - i + 1);
                }
                j++;
                if (j == size) {
                    break;
                }
                target -= infiniteNums.get(j);
            } else if (target > 0) {
                j++;
                if (j == size) {
                    break;
                }
                target -= infiniteNums.get(j);
            } else {
                target += infiniteNums.get(i);
                i++;
                if (i > j) {
                    j++;
                    if (j == size) {
                        break;
                    }
                    target -= infiniteNums.get(j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSizeSubarray(
                new int[]{18, 3, 11, 19, 7, 16, 6, 7, 3, 6, 18, 9, 9, 1, 14, 17, 15, 14, 12, 10}, 7));
    }
}
