package code.doublePointer;

/**
 * 反转单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ')
                end++;
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char c = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, c);
            start++;
            end--;
        }
    }

    public StringBuilder removeSpace(String s) {
        s = s.trim();
        int start = 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ')
                sb.append(c);
            start++;
        }
        return sb;
    }
}
