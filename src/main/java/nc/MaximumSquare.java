package nc;

/**
 * 最大正方形
 */
public class MaximumSquare {
    public int solve(char[][] matrix) {
        // write code here
        if (matrix.length == 0)
            return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int maxSide = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
