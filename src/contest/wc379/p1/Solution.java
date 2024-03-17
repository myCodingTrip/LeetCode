package contest.wc379.p1;

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int len = 0;
        int res = 0;
        for (int[] dimension : dimensions) {
            int pow = (int) (Math.pow(dimension[0], 2) + Math.pow(dimension[1], 2));
            if (pow > len) {
                len = pow;
                res = dimension[0] * dimension[1];
            } else if (pow == len) {
                res = Math.max(res, dimension[0] * dimension[1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().areaOfMaxDiagonal(new int[][]{{9, 3}, {8, 6}}));
        System.out.println(new Solution().areaOfMaxDiagonal(new int[][]{{3, 4}, {2, 2}}));
        System.out.println(new Solution().areaOfMaxDiagonal(new int[][]{{3, 5}, {4, 4}}));
    }
}
