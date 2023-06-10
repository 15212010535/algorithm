package code.string;

/**
 * 找出字符串中第一个匹配项的下标
 */
public class StrStr {
    public int strStrOne(String haystack, String needle) {
        int m, n;
        if ((m = needle.length()) == 0) {
            return 0;
        }
        if ((n = haystack.length()) < m)
            return -1;
        int i = 0;
        int j = 0;
        while (i < n - m + 1) {
            while (i < n && haystack.charAt(i) != needle.charAt(j))
                i++;
            if (i == n)
                return -1;
            i++;
            j++;
            while (i < n && j < m && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == m)
                return i - j;
            else {
                i -= j - 1;
                j = 0;
            }
        }
        return -1;
    }

    // 前缀表
    public int strStrTwo(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(i) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }
}
