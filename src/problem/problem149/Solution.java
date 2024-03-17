package problem.problem149;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int res0 = 1;
            int same = 0;
            Map<Fraction, Integer> map = new HashMap<>();
            int x = points[i][0];
            int y = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[j][0];
                int y1 = points[j][1];
                if (x == x1 && y == y1) {
                    same++;
                    continue;
                }
                Fraction f = new Fraction(y - y1, x - x1);
                int val = map.getOrDefault(f, 1) + 1;
                if (val > res0) res0 = val;
                map.put(f, val);
            }
            for (Fraction key : map.keySet()) {
                int val = map.getOrDefault(key, 1) + same;
                if (val > res0) res0 = val;
            }
            if (same > 0 && map.size() == 0)
                res0 += same;
            if (res0 > res) res = res0;
        }
        return res;
    }

    /**
     * 分数类pai
     */
    static class Fraction {

        /**
         * 是否正数
         */
        public Boolean positive = true;

        /**
         * 分子
         */
        public Integer numerator;
        /**
         * 分母
         */
        public Integer denominator;

        Fraction(Integer numerator, Integer denominator) {

            if (denominator == 0 || numerator == 0) {
                this.numerator = Math.abs(numerator);
                this.denominator = Math.abs(denominator);
            } else {
                int gcd = gcd(numerator, denominator);
                if (gcd == 0)
                    System.err.println(numerator + " " + denominator);
                this.numerator = Math.abs(numerator / gcd);
                this.denominator = Math.abs(denominator / gcd);
                if (numerator / denominator < 0)
                    positive = false;
            }
        }

        @Override
        public int hashCode() {
            if (denominator == 0) return Integer.MAX_VALUE;
            if (numerator == 0) return 0;
            int hash = numerator / denominator;
            if (positive)
                return hash;
            else
                return -hash;
        }

        @Override
        public boolean equals(Object obj) {
            Fraction fraction = (Fraction) obj;
            if (numerator.equals(0) && numerator.equals(fraction.numerator)) return true;
            if (denominator.equals(0) && denominator.equals(fraction.denominator)) return true;
            return fraction.numerator.equals(numerator) && fraction.denominator.equals(denominator) && fraction.positive.equals(positive);
        }

        // 最大公约数
        private static int gcd(int n1, int n2) {

            n1 = Math.abs(n1);
            n2 = Math.abs(n2);

            int gcd = 0;

            // 交换n1、n2的值
            if (n1 < n2) {
                int t = n1;
                n1 = n2;
                n2 = t;
            }
            if (n1 % n2 == 0) {
                gcd = n2;
            }

            //辗转相除法
            while (n1 % n2 > 0) {
                n1 = n1 % n2;

                if (n1 < n2) {
                    int t = n1;
                    n1 = n2;
                    n2 = t;
                }
                if (n1 % n2 == 0) {
                    gcd = n2;
                }
            }
            return gcd;

        }

        @Override
        public String toString() {
            String flag = positive ? "+" : "-";
            return flag + numerator + "/" + denominator;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maxPoints(
//                new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));//4
//        System.out.println(new Solution().maxPoints(
//                new int[][]{{1, 1}, {1, 1}, {1, 1}}));//3
//        System.out.println(new Solution().maxPoints(
//                new int[][]{{84, 250}, {0, 0}, {1, 0}, {0, -70},
//                        {0, -70}, {1, -1}, {21, 10}, {42, 90}, {-42, -230}}));//6
//        System.out.println(new Solution().maxPoints(
//                new int[][]{{2, 3}, {3, 3}, {-5, 3}}));//3
//        System.out.println(new Solution().maxPoints(
//                new int[][]{{0, 0}, {94911151, 94911150}, {94911152, 94911151}}));//2
        System.out.println(new Solution().maxPoints(
                new int[][]{{4, 0}, {4, -1}, {4, 5}}));
    }
}
