package contest.wc375.p2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        int length = variables.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];
            if (forMultiplication(a, b, c, m) == target) {
                res.add(i);
            }
        }
        return res;
    }

    public long forMultiplication(int a, int b, int c, int m) {
        long x = 1;
        for (int i = 0; i < b; i++) {
            x = (x * a) % 10;     //(a*b)%m=（a%m*b%m）%m
        }
        long y = x % 10;
        long z = 1;
        for (int i = 0; i < c; i++) {
            z = (z * y) % m;
        }
        return z;
    }

    public long calByPow(int a, int b, int c, int m) {
        //Math.pow(31, 12)=7.8766278378854976E17 丢失一位精度
        double pow = Math.pow(a, b);
        System.out.println(pow);
        return (int) Math.pow(pow % 10, c) % m;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().getGoodIndices(new int[][]{{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}}, 2));
        //System.out.println(new Solution().getGoodIndices(new int[][]{{39, 3, 1000, 1000}}, 17));
        //System.out.println(new Solution().calByPow(31,12,21,24));
        System.out.println(new Solution().forMultiplication(51, 35, 21, 52));  //溢出

    }
}
