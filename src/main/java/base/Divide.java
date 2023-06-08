package base;

/**
 * 两数相除
 */
public class Divide {
    //dividend / divisor
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) { //不加上会超时
            return dividend;
        }
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        if (a > b) {
            return 0;
        }
        int ans = divideHelper(a, b);

        return sign > 0 ? ans : -ans;
    }

    private int divideHelper(int a, int b) {
        if (a > b) {
            return 0;
        }

        int count = 1;
        int tmp = b;
        while (tmp + tmp >= a && tmp + tmp < 0) { //两个负数相加溢出会大于0
            tmp += tmp;
            count += count;
        }

        return count + divideHelper(a - tmp, b);
    }
}
