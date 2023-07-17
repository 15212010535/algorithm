package nc;

/**
 * 丢棋子问题
 */
public class ThrowPawns {
    public int solve(int n, int k) {
        // write code here
        if (k == 1)
            return n;
        int cnt = (int) (Math.log(n) / Math.log(2)) + 1;
        if (k >= cnt)
            return cnt;
        int[] dp = new int[k + 1];
        int times = 1;
        while (true) {
            for (int i = k; i > 0; i--) {
                dp[i] += dp[i - 1] + 1;
                if (dp[i] >= n) {
                    return times;
                }
            }
            dp[1] = times++;
        }
    }
}
