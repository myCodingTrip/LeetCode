package contest.wc387.p2;

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sumArr = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumArr[i + 1][j + 1] = sumArr[i + 1][j] + sumArr[i][j + 1] - sumArr[i][j] + grid[i][j];
                if (sumArr[i + 1][j + 1] <= k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubmatrices(new int[][]{{7, 6, 3}, {6, 6, 1}}, 18));
        System.out.println(new Solution().countSubmatrices(new int[][]{{7, 2, 9}, {1, 5, 0}, {2, 6, 6}}, 20));
    }
}
