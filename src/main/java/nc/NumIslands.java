package nc;

/**
 * 岛屿数量
 */
public class NumIslands {
    public int solve (char[][] grid) {
        // write code here
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'){
                    clear(grid,i,j);
                    num++;
                }
            }
        }
        return num;
    }

    public void clear(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            clear(grid, i - 1, j);
            clear(grid, i + 1, j);
            clear(grid, i, j - 1);
            clear(grid, i, j + 1);
        }
    }
}
