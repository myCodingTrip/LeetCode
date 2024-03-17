package contest.wc386.p3;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int min = n - 1, max = changeIndices.length + 1;
        int res = -1;
        while (min + 1 < max) {
            int mid = (min + max) / 2;
            int[] copyOf = Arrays.copyOf(nums, n);
            boolean check = check(copyOf, changeIndices, mid);
            if (check) {
                if (res == -1) {
                    res = mid;
                } else {
                    res = Math.min(res, mid);
                }
                max = (min + max) / 2;
            } else {
                min = (min + max) / 2;
            }
        }
        return res;
    }

    public boolean check(int[] nums, int[] changeIndices, int mid) {
        int n = nums.length;
        List<Integer> idxList = new LinkedList<>();
        for (int i = mid - 1; i >= 0; i--) {
            if (!idxList.contains(changeIndices[i])) {
                idxList.add(changeIndices[i]);
            }
        }
        Collections.reverse(idxList);
        if (idxList.size() != n) {
            return false;
        }
        for (int i = 0; i < mid; i++) {
            int changeIndex = changeIndices[i];
            Integer idx = idxList.get(0);
            if (changeIndex == idx && nums[changeIndex - 1] == 0) {
                idxList.remove(0);
                if (idxList.isEmpty()) {
                    return true;
                }
            } else if (nums[idx - 1] > 0) {
                nums[idx - 1]--;
            } else {
                for (Integer x : idxList) {
                    if (nums[x - 1] > 0) {
                        nums[x - 1]--;
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().earliestSecondToMarkIndices(new int[]{2, 2, 0}, new int[]{2, 2, 2, 2, 3, 2, 2, 1}));
        //System.out.println(new Solution().earliestSecondToMarkIndices(new int[]{0}, new int[]{1, 1, 1}));
        System.out.println(new Solution().earliestSecondToMarkIndices(new int[]{2, 0, 2},
                new int[]{3, 2, 1, 2, 2, 3, 3, 2, 1, 2, 3, 3, 3, 3, 1, 3, 1, 3}));
//        System.out.println(new Solution().check(new int[]{2, 0, 2},
//                new int[]{3, 2, 1, 2, 2, 3, 3, 2, 1, 2, 3, 3, 3, 3, 1, 3, 1, 3}, 14));
    }
}
