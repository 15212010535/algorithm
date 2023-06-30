package code.dp;

import java.util.Arrays;

/**
 * 分割等和子集
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int target = sum / 2;
        if (sum % 2 != 0 || maxNum > target)
            return false;
        boolean[][] dp = new boolean[n][target+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if(j>=num)
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n - 1][target];
    }
}