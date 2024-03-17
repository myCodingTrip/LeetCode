package contest.wc373.p1;

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int height = mat.length;
        int width = mat[0].length;
        int[][] a = new int[height][width];
//        for (int i = 0; i < height; i++) {
//            a[i] = Arrays.copyOf(mat[i], width);
//        }

        for (int c = 0; c < k; c++) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width / 2; j++) {
                    a[i][j] = mat[i][(j + k) % width];
                    a[i][(j + k) % width] = mat[i][j];
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (a[j][i] != mat[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().areSimilar(new int[][]{{7, 1, 7, 7, 1, 7, 7, 1, 7}, {5, 10, 1, 5, 10, 1, 5, 10, 1}}, 3));
    }
}
