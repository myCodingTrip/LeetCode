package problem.problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    private int[] arr;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        arr = candidates;
        nextCombine(0, target, arr[0]);
        return res;
    }

    private void nextCombine(int start, int target, int x) {

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == x) {
                continue;
            }
            int remain = target - arr[i];
            if (remain < 0) {
                break;
            } else if (remain == 0) {
                temp.add(arr[i]);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                break;
            } else if (i == arr.length - 1) {
                break;
            }
            x = arr[i];
            temp.add(arr[i]);
            nextCombine(i + 1, remain, arr[i + 1]);
            temp.remove(temp.size() - 1);
        }
    }
}
