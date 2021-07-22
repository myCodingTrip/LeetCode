package problem46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[] used;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        getPermutation(nums, 0, new ArrayList<>());
        return res;
    }

    private void getPermutation(int[] nums, int index, List<Integer> temp) {
//        System.out.println(index+":"+temp);
        if (temp.size() == nums.length) {
//            System.out.println(temp);
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                getPermutation(nums, index + 1, temp);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}