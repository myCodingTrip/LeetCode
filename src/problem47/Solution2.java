package problem47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40ms 16.51%——>2ms 78%——>1ms 100%
class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        nextPerm(nums, 0, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }

    private void nextPerm(int[] nums, int depth, List<Integer> temp, int start) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        //2ms 78%——>1ms 100%
        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                if (i > start && nums[i] == nums[start]) {
                    continue;
                }
                start = i;
                temp.add(nums[i]);
                used[i] = true;
                int start0 = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (!used[j]) {
                        start0 = j;
                        break;
                    }
                }
                nextPerm(nums, depth + 1, temp, start0);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().permuteUnique(new int[]{2, 2, 1, 1}));
    }
}