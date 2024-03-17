package problem.problem417;

import javafx.util.Pair;

import java.util.*;

//todo 1570 ms 5.09%
class Solution {

    int[][] gMatrix;
    boolean[][] visited;
    boolean[][] reachable;
    int width;
    int height;
    int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        gMatrix = matrix;
        width = matrix.length;
        height = matrix[0].length;
        visited = new boolean[width][height];
        reachable = new boolean[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (bfs(i, j)) {
                    reachable[i][j] = true;
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
//                System.out.println("--------------------");
                for (boolean[] arr : visited) {
                    Arrays.fill(arr, false);
                }
            }
        }

        return res;
    }

    private boolean bfs(int x, int y) {
        boolean b1 = false;
        boolean b2 = false;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Pair<>(x, y));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
//            System.out.println(poll);
            for (int i = 0; i < 4; i++) {
                Integer oldX = poll.getKey();
                Integer oldY = poll.getValue();
                int newX = oldX + direction[i][0];
                int newY = oldY + direction[i][1];

                if (newX < 0 || newY < 0) {
                    b1 = true;
                    if (b2) {
                        return true;
                    }
                } else if (newX == width || newY == height) {
                    b2 = true;
                    if (b1) {
                        return true;
                    }
                } else if (gMatrix[newX][newY] <= gMatrix[oldX][oldY] && !visited[newX][newY]) {
                    if (reachable[newX][newY]) {
                        return true;
                    }
                    visited[newX][newY] = true;
                    queue.offer(new Pair<>(newX, newY));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }


}
