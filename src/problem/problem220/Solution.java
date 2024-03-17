package problem.problem220;

import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k > nums.length - 1) k = nums.length - 1;

        //取值范围！！！
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i <= k; i++) {
            int v = nums[i];
            // 查找[v - t, v + t]的数字
            if (set.floor((long) v + t) != null && set.floor((long) v + t) >= (long) v - t)
                return true;
            set.add((long) nums[i]);
        }

        for (int i = k + 1; i < nums.length; i++) {
            set.remove((long) nums[i - k - 1]);

            int v = nums[i];
            if (set.floor((long) v + t) != null && set.floor((long) v + t) >= (long) v - t)
                return true;
            set.add((long) nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
//        System.out.println(sol.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(sol.containsNearbyAlmostDuplicate(new int[]{0, 2147483647}, 1, 2147483647));
    }
}
