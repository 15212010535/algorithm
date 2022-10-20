package 刷题;

import java.util.Arrays;

/**
 * 不同的子序列
 */
public class DistinctSubseqII {
    public static int distinctSubseqII(String s) {
        final int MOD = 1000000007;
        // 记录最后一个字符
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int n = s.length();
        // 存放前i个字母不同子序列的可能
        int[] f = new int[n];
        Arrays.fill(f, 1);
        // 从前往后遍历
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                // 除了当前字符，还有别的字符
                if (last[j] != -1) {
                    // f[last[j]: 当前字符的前一个字符有多少种可能
                    f[i] = (f[i] + f[last[j]]) % MOD;
                }
            }
            // 记录出现的元素，在f中的下标,防止元素重复
            last[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        // 通过last获取最新的记录数,防止元素重复,重复计算
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1) {
                ans = (ans + f[last[i]]) % MOD;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(distinctSubseqII("aba"));
    }
}
