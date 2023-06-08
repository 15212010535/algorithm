package base;

import java.util.Arrays;

/**
 * 不同路径
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsTwo(int m, int n) {
        int[] preRow = new int[n];
        int[] curRow = new int[n];
        for (int i = 0; i < n; i++) {
            preRow[i] = 1;
            curRow[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                curRow[j] = curRow[j - 1] + preRow[j];
            }
            preRow = curRow.clone();
        }
        return curRow[n - 1];
    }

    public int uniquePathsThree(int m, int n) {
        int[] curRow = new int[n];
        Arrays.fill(curRow, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                curRow[j] += curRow[j - 1];
            }
        }
        return curRow[n - 1];
    }
}
