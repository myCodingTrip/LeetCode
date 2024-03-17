package problem.problem90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);
        return res;
    }

    private void dfs(int start, int[] nums) {
        int mark = start;
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > mark && nums[i] == nums[mark]) {
                continue;
            }
            mark = i;
            temp.add(nums[i]);
            dfs(i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
