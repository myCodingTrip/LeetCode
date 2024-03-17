package problem.problem79;

class Solution {

    //方向数组 右下左上顺时针顺序
    int[][] d = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    boolean[][] visited;
    int width, heigtht;

    public boolean exist(char[][] board, String word) {
        width = board.length;
        heigtht = board[0].length;
        visited = new boolean[width][heigtht];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (find(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int index, int startX, int startY) {
        if (index == word.length() - 1)
            return board[startX][startY] == word.charAt(index);
        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY]
                        && find(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            visited[startX][startY] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < heigtht;
    }
}
