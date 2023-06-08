package base;

/**
 * 岛屿的数量
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]){
                    dfs(grid, isVisited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] isVisited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        if(!isVisited[i][j]){
            isVisited[i][j] = true;
            dfs(grid, isVisited, i + 1, j);
            dfs(grid, isVisited, i - 1, j);
            dfs(grid, isVisited, i, j + 1);
            dfs(grid, isVisited, i, j - 1);
        }
    }
}
