package problem.problem39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    private int[] arr;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        arr = candidates;
        nextCombine(0, target);
        return res;
    }

    private void nextCombine(int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            int remain = target - arr[i];
            //5ms 44.9%——>3ms 89.83
            if (remain < 0) {
                break;
            }
            temp.add(arr[i]);
            nextCombine(i, remain);
            temp.remove(temp.size() - 1);
        }
    }
}
