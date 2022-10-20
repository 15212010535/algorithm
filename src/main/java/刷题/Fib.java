package 刷题;

import java.util.Vector;

/**
 * 斐波拉契数列
 */
public class Fib {

    // 暴力递归
    public static int fib1(int N) {
        if (N == 1 || N == 2)
            return 1;
        return fib1(N - 1) + fib1(N - 2);
    }

    // 备忘录方法
    public static int fib2(int N) {
        if (N < 0) {
            return N;
        }
        int[] memo = new int[N + 1];
        return helper(memo, N);
    }

    public static int helper(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        // 这一步比较重要
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    // dp数组的迭代解法
    static int fib3(int N) {
        int[] dp = new int[N + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    // 改进
    static int fib4(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 3; i <= N; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    public static void main(String[] args) {
//        int res = fib1(4);
//        int res = fib2(10);
//        int res = fib3(10);
        int res = fib4(10);
        System.out.println(res);
    }
}

