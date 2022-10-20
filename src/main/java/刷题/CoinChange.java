package 刷题;

import java.util.Arrays;

public class CoinChange {

    // 贪心算法
    public static int coinChange1(int[] coins, int amount) {
        int res = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                res += 1;
            }
        }
        return amount == 0 ? res : -1;
    }

    // 动态规划
    public static int coinChange2(int[] money, int target) {
        if (target == 0)
            return 0;
        if (money == null || money.length == 0)
            return -1;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < money.length && i >= money[j]; j++) {
                dp[i] = Math.min(dp[i], dp[i - money[j]] + 1);
            }
//             System.out.println(Arrays.toString(dp));
        }
        return dp[target] == target + 1 ? -1 : dp[target];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5, 10};
        int res = coinChange2(coins, 23);
        System.out.println(res);
    }
}
