package code.dp;

import java.util.Arrays;

/**
 * 目标和
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target < 0 && sum < -target)
            return 0;
        if ((target + sum) % 2 != 0) return 0;
        int size = (sum + target) >> 1;
        if (size < 0)
            size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}
