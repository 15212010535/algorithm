package code.string;

/**
 * 重复的子字符串
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.equals(""))
            return false;
        int len = s.length();
        s = " " + s;
        char[] chars = s.toCharArray();
        // 构造next数组过程，j从0开始(空格)，i从2开始。
        int[] next = new int[len + 1];
        for (int i = 2, j = 0; i <= len; i++) {
            while (j > 0 && chars[i] != chars[j + 1])
                j = next[j];
            if (chars[i] == chars[j + 1])
                j++;
            next[i] = j;
        }
        return next[len] > 0 && len % (len - next[len]) == 0;
    }
}
