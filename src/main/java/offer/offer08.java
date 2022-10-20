package offer;

/**
 * 斐波那契数列
 */
public class offer08 {
    public static int fib(int n) {
        if (n < 2)
            return n;
        int mod = 1000000007;
        int a = 0, b = 1, c = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = c;
            c = (a + b) % mod;
        }
        return c;
    }

    public static void main(String[] args) {
        int fib = fib(42);
        System.out.println(fib);
    }
}
