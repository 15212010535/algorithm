package code.dp;

import java.util.Arrays;

/**
 * 完全平方数
 */
public class NumSquares {
    // 先遍历物品，在遍历背包
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max)
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    // 先遍历背包，在遍历物品
    public int numSquaresTwo(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
