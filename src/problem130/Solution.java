package problem130;

import java.util.Arrays;

class Solution {

    char[][] gBoard;
    int width;
    int height;
    boolean visited[][];
    boolean change[][];

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        gBoard = board;
        width = board.length;
        height = board[0].length;
        visited = new boolean[width][height];

        change = new boolean[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                change[i][j] = true;
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == 'O') {
                    dfs(i, j);
                }
            }
        }
    }

    private boolean dfs(int x, int y) {

        if (x == width || y == height || x < 0 || y < 0) return false;

        if (gBoard[x][y] == 'X' || visited[x][y]) {
            return change[x][y];
        }

        visited[x][y] = true;

        System.out.println(x + " " + y);

        boolean b1 = dfs(x - 1, y);
        if (!b1) {
            change[x][y] = false;
            return false;
        }
        boolean b2 = dfs(x, y + 1);
        if (!b2) {
            change[x][y] = false;
            return false;
        }
        boolean b3 = dfs(x + 1, y);
        if (!b3) {
            change[x][y] = false;
            return false;
        }
        boolean b4 = dfs(x, y - 1);
        if (!b4) {
            change[x][y] = false;
            return false;
        }

        change[x][y] = true;

        if (change[x][y]) {
            gBoard[x][y] = 'X';
            System.out.println(x + "-------------------------" + y);
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        char[][] board = {
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}
        };
        new Solution().solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}