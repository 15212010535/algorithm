package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 */
public class offer17 {
    public static int[] printNumbers(int n) {
        int length = (int) Math.pow(10, n);
        int[] res = new int[length - 1];
        for (int i = 0; i < length - 1; i++)
            res[i] = i + 1;
        return res;
    }

    public static void main(String[] args) {
        int[] ints = printNumbers(2);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
