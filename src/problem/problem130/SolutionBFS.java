package problem.problem130;

import javafx.util.Pair;

import java.util.*;

//todo 9ms 14.43%
class SolutionBFS {

    char[][] gBoard;
    int width;
    int height;
    boolean visited[][];
    int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    List<Pair<Integer, Integer>> records = new ArrayList<>();

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        gBoard = board;
        width = board.length;
        height = board[0].length;
        visited = new boolean[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    if (bfs(i, j)) {
                        for (Pair<Integer, Integer> record : records) {
                            gBoard[record.getKey()][record.getValue()] = 'X';
                        }
                    }
                    records.clear();
                }
            }
        }
    }

    private boolean bfs(int x, int y) {
        //是否被X包围
        boolean encompassed = true;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            records.add(pair);
            for (int i = 0; i < 4; i++) {
                int newX = pair.getKey() + direction[i][0];
                int newY = pair.getValue() + direction[i][1];
                if (newX == width || newY == height || newX < 0 || newY < 0) {
                    encompassed = false;
                } else if (gBoard[newX][newY] == 'O' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new Pair<>(newX, newY));
                }
            }
        }
        return encompassed;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'O', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        new SolutionBFS().solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
