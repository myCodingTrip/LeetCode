package problem.problem37;

//00 01 02 03 04 05 06 07 08
//10 11 12 13 14 15 16 17 18
//20 21 22 23 24 25 26 27 28
//30 31 32 33 34 35 36 37 38
//40 41 42 43 44 45 46 47 48
//50 51 52 53 54 55 56 57 58
//60 61 62 63 64 65 66 67 68
//70 71 72 73 74 75 76 77 78
//80 81 82 83 84 85 86 87 88

class Solution {

    //todo 35.3%
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int x, int y) {
        if (x == 9) {
            return true;
        }
        if (board[x][y] == '.') {
            for (char k = '1'; k <= '9'; k++) {
                boolean yes = true;
                for (int l = 0; l < 9; l++) {
                    if (board[x][l] == k) {
                        yes = false;
                        break;
                    }
                }
                for (int l = 0; l < 9; l++) {
                    if (board[l][y] == k) {
                        yes = false;
                        break;
                    }
                }
                int a = x / 3 * 3;
                int b = y / 3 * 3;
                for (int l = 0; l < 3; l++) {
                    for (int m = 0; m < 3; m++) {
                        if (board[a + l][b + m] == k) {
                            yes = false;
                            break;
                        }
                    }
                }
                if (yes) {
                    board[x][y] = k;
                    boolean success = false;
                    if (y == 8) {
                        success = dfs(board, x + 1, 0);
                    } else {
                        success = dfs(board, x, y + 1);
                    }
                    if (success) return true;
                    board[x][y] = '.';
                }
            }
        } else {
            if (y == 8) {
                return dfs(board, x + 1, 0);
            } else {
                return dfs(board, x, y + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution().solveSudoku(board);
        System.out.println(board);
    }
}
