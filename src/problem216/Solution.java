package problem216;

import java.util.ArrayList;
import java.util.List;

//100%
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        nextCombine(1, n, k);
        return res;
    }

    private void nextCombine(int start, int n, int k) {
        if (k == 0) return;
        for (int i = start; i <= 9; i++) {
            int remain = n - i;
            if (remain < 0) {
                break;
            } else if (k == 1 && remain == 0) {
                temp.add(i);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            temp.add(i);
            nextCombine(i + 1, remain, k - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
    }
}