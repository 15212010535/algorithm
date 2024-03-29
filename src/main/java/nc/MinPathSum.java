package nc;

/**
 * 矩阵的最小路径和
 */
public class MinPathSum {

    public int minPathSum(int[][] matrix) {
        // write code here
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];
            }
        }
        return dp[matrix.length-1][matrix[0].length-1];
    }
}
