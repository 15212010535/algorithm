package base;

/**
 * 最长回文子串
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[length][length];
        char[] charArray = s.toCharArray();
        // 对角线表示单个字符，一定是回文。
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 最后两个字符，相当于找到了切分线了
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        longestPalindrome("abccba");
    }
}
