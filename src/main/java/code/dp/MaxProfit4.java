package code.dp;

/**
 * 买卖股票的最佳时机 IV
 */
public class MaxProfit4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        int len = prices.length;
        int[][] dp = new int[len][2 * k + 1];
        for (int i = 1; i < k * 2; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][k * 2];
    }
}
