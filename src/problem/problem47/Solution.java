package problem.problem47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//40ms 16.51%
class Solution {

    private Set<List<Integer>> res = new HashSet<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        nextPerm(nums, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void nextPerm(int[] nums, int depth, List<Integer> temp) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                nextPerm(nums, depth + 1, temp);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2}));
    }
}
