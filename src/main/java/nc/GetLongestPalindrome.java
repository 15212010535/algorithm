package nc;

/**
 *  最长回文子串
 */
public class GetLongestPalindrome {

    public int getLongestPalindrome(String A) {
        // write code here
        int len = A.length();
        if (len < 2) {
            return len;
        }
        char[] chars = A.toCharArray();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (i - j < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
                if (dp[i][j]) {
                    maxLen = Math.max(maxLen, i - j + 1);
                }
            }
        }
        return maxLen;
    }
}
