package 刷题.五百;

/**
 * 5、最长回文数
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int max = -1;
        String string = "";
        for (int i = 0; i < s.length(); i++) {
            // 寻找字串
            String str = findStr(s.substring(i));
            // 判断是否是回文数
            int palindrome = palindrome(str);
            // 不是回文数，并且长度大于1
            while (palindrome == -1 && str.length() > 1) {
                str = findStr(str.substring(0, str.length() - 1));
                palindrome = palindrome(str);
            }
            if(palindrome>max){
                string = str;
                max = palindrome;
            }
        }
        return string;
    }

    public static String findStr(String s) {
        int index = -1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(0) == s.charAt(i)) {
                index = i;
            }
        }
        return index != -1 ? s.substring(0, index + 1) : s.substring(0, 1);
    }

    public static int palindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                break;
            }
        }
        return l > r ? s.length() : -1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
