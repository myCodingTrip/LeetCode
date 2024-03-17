package contest.wc384.p1;

class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] ans = new int[height][width];
        int[] maxArr = new int[width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                maxArr[i] = Math.max(maxArr[i], matrix[j][i]);
                ans[j][i] = matrix[j][i];
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[j][i] == -1) {
                    ans[j][i] = maxArr[i];
                }
            }
        }
        return ans;
    }
}
