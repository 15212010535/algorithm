package code.dp;

/**
 * 爬楼梯
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairsTwo(int n) {
        int[] dp = new int[n + 1];
        int m = 2;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i >= j)
                    dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }
}
