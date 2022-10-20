package offer;


import java.util.Arrays;

/**
 * 替换空格
 */
public class offer03 {
    public static String replaceSpace(String s) {
        char[] chars = new char[s.length() * 3];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[j] = '%';
                chars[j + 1] = '2';
                chars[j + 2] = '0';
                j += 3;
            } else {
                chars[j] = s.charAt(i);
                j++;
            }
        }
        return String.copyValueOf(chars).trim();
    }

    public static void main(String[] args) {
        String str = "We are happy.";
        String s = replaceSpace(str);
        System.out.println(s);
    }
}
