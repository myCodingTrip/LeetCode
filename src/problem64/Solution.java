package problem64;

class Solution {

    //todo 32.57%
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];

        distance[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int left = Integer.MAX_VALUE;
                if (i > 0) {
                    left = distance[i - 1][j];
                }
                int up = Integer.MAX_VALUE;
                if (j > 0) {
                    up = distance[i][j - 1];
                }
                distance[i][j] = grid[i][j] + Math.min(left, up);
            }
        }
        return distance[m - 1][n - 1];
    }
}