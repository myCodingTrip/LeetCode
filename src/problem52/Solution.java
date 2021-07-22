package problem52;

class Solution {

    boolean[] col;
    boolean[] dig1;
    boolean[] dig2;
    int res = 0;

    public int totalNQueens(int n) {
        if (n == 0) return res;
        col = new boolean[n];
        dig1 = new boolean[2 * n - 1];
        dig2 = new boolean[2 * n - 1];
        putQueen(n, 0);
        return res;
    }

    private void putQueen(int n, int rowIndex) {
        if (rowIndex == n) {
            res++;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!col[colIndex] && !dig1[rowIndex + colIndex] && !dig2[n - rowIndex + colIndex - 1]) {
                col[colIndex] = true;
                dig1[rowIndex + colIndex] = true;
                dig2[n - rowIndex + colIndex - 1] = true;
                putQueen(n, rowIndex + 1);
                col[colIndex] = false;
                dig1[rowIndex + colIndex] = false;
                dig2[n - rowIndex + colIndex - 1] = false;
            }
        }
    }
}