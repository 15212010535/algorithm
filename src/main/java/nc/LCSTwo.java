package nc;

import java.util.Arrays;
import java.util.Objects;

/**
 * 最长公共子序列(二)
 */
public class LCSTwo {
    public String lcs(String s1, String s2) {
        // write code here
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= s1.length(); i++) {
            char c = s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++) {
                char charAt = s2.charAt(j - 1);
                if (c == charAt) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        Arrays.stream(dp).forEach(ints -> {
            Arrays.stream(ints).forEach(System.out::print);
            System.out.println();
        });
        int i = s1.length(), j = s2.length();
        while (dp[i][j] != 0) {
            if (dp[i][j] == dp[i - 1][j] && dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else if (dp[i][j] > dp[i - 1][j] && dp[i][j] > dp[i][j - 1]) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i][j - 1] && dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            }
        }
        return Objects.equals(sb.reverse().toString(), "") ?"-1":sb.reverse().toString();
    }
}
