package problem.problem77;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < 1) return res;
        nextCombine(1, n, k, new ArrayList<>());
        return res;
    }


    /**
     * 在[start,n]的区间上找一个数加入组合
     *
     * @param start 遍历开始的位置
     * @param n
     * @param k
     * @param temp  维护一个结果
     */
    private void nextCombine(int start, int n, int k, List<Integer> temp) {
        //System.out.println(temp+" from "+start);
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            //System.out.println("return");
            return;
        }
        int need = k - temp.size();//还差多少个元素完成排序
        int end = n - need + 1;//n-end+1==need  [end,n]存在need个元素
        //n->end    50ms->3ms
        for (int i = start; i <= end; i++) {
            temp.add(i);
            nextCombine(i + 1, n, k, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 3));
    }
}
