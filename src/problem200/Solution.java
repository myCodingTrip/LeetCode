package problem200;

/**
 * floodfill
 */
class Solution {

    int[][] d = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    boolean[][] visited;
    int width, heigtht;

    public int numIslands(char[][] grid) {
        if (grid.length <= 0 || grid[0].length <= 0) return 0;
        width = grid.length;
        heigtht = grid[0].length;
        visited = new boolean[width][heigtht];

        int res = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigtht; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            //判断放在这里，少一次递归调用5ms->2ms
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1')
                dfs(grid, newX, newY);
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < heigtht;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }
}