package problem.problem51;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 */
class Solution {

    /**
     * 表示某一列是否有皇后
     */
    private boolean[] col;
    /**
     * 表示一组对角线是否有皇后
     */
    private boolean[] dia1;
    /**
     * 表示另一组对角线是否有皇后
     */
    private boolean[] dia2;
    /**
     * 用于保存空棋盘的一行 保持不变，仅用于复制
     */
    private char[] emptyBoardRow;

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return res;

        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        emptyBoardRow = sb.toString().toCharArray();

        putQueen(n, 0, new ArrayList<>());

        return res;
    }

    /**
     * 递归生成需要的棋盘
     *
     * @param n        总行数
     * @param rowIndex 第几行
     * @param row      保存每一行Q的位置
     */
    private void putQueen(int n, int rowIndex, List<Integer> row) {
        if (rowIndex == n) {
            if (row.size() == n) {
//                System.out.println(row);
                addRes(n, row);
            }
            return;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!col[colIndex] && !dia1[rowIndex + colIndex] && !dia2[n + rowIndex - colIndex - 1]) {
                col[colIndex] = true;
                dia1[colIndex + rowIndex] = true;
                dia2[colIndex - rowIndex + n - 1] = true;
                row.add(colIndex);
                putQueen(n, rowIndex + 1, row);
                col[colIndex] = false;
                dia1[colIndex + rowIndex] = false;
                dia2[colIndex - rowIndex + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    /**
     * @param n   总行数
     * @param row 保存每一行Q的位置
     */
    private void addRes(int n, List<Integer> row) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] queenBoardRow = new char[n];
            System.arraycopy(emptyBoardRow, 0, queenBoardRow, 0, n);
            queenBoardRow[row.get(i)] = 'Q';
            board.add(new String(queenBoardRow));
        }
        res.add(board);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(1));
    }

}
