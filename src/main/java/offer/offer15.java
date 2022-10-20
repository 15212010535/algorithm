package offer;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数
 */
public class offer15 {

    // 循环检查二进制位
    public static int hammingWeight01(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // i 左移以为即x2
            if ((n & (1 << i)) != 0) {
                System.out.println(1 << i);
                res++;
            }
        }
        return res;
    }

    public static int hammingWeight02(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int weight = hammingWeight02(11);
        System.out.println(weight);
    }
}
