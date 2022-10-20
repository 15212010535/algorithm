package 刷题;

import java.util.Arrays;

/**
 * 最大交换
 */
public class MaximumSwap {

    private static int index = 0;

    public static int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        // leedcode 编译原因
        index = 0;
        String res = swap(chars);
        String concat = str.substring(0, index).concat(res);
        return Integer.parseInt(concat);
    }

    public static String swap(char[] chars) {
        if (chars.length <= 1) {
            return String.valueOf(chars[0]);
        }
        int max = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[max] <= chars[i]) {
                max = i;
            }
        }
        if (max != 0 && chars[0] != chars[max]) {
            char temp = chars[max];
            chars[max] = chars[0];
            chars[0] = temp;
            return new String(chars);
        } else {
            String s = new String(chars);
            chars = s.substring(1).toCharArray();
            index++;
            return swap(chars);
        }
    }

    public static void main(String[] args) {
        int num = maximumSwap(99753);
        System.out.println(num);
    }
}
