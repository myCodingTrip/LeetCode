package problem.problem120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    //todo 12.56
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        if (triangle.size() == 0) return 0;
        List<Integer> temp = new ArrayList<>();
        temp.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            int size = i + 1;
            List<Integer> lastLayer = new ArrayList<>(temp);
            temp.clear();
            List<Integer> thisLayer = triangle.get(i);
            for (int j = 0; j < size; j++) {
                Integer num = thisLayer.get(j);
                if (j == 0) {
                    temp.add(num + lastLayer.get(j));
                } else if (j == size - 1) {
                    temp.add(num + lastLayer.get(j - 1));
                } else {
                    temp.add(num + Math.min(lastLayer.get(j - 1), lastLayer.get(j)));
                }
            }
        }
        for (Integer integer : temp) {
            res = Math.min(res, integer);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[][] triangle = {
                new Integer[]{2},
                new Integer[]{3, 4},
                new Integer[]{6, 5, 7},
                new Integer[]{4, 1, 8, 3}
        };
        List<List<Integer>> list0 = new ArrayList<>();
        for (Integer[] arr : triangle) {
            //数组转ArrayList
            List<Integer> list = new ArrayList<>(Arrays.asList(arr));
            list0.add(list);
        }
        System.out.println(new Solution().minimumTotal(list0));
    }
}
