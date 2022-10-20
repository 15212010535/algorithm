package 刷题;

/**
 * 仅执行一次字符串交换能否使两个字符串相等
 */
public class AreAlmostEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] arr = new int[3];
        int count = 0, i = 0;
        for (; i < s1.length() && count < 3; i++) {
            if (chars1[i] != chars2[i]) {
                arr[count] = i;
                count++;
            }
        }
        return chars1[arr[0]] == chars2[arr[1]] && chars1[arr[1]] == chars2[arr[0]] && count < 3;
    }
}
