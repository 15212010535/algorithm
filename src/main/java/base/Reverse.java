package base;

/**
 * 整数反转
 */
public class Reverse {
    public static int reverse(int x) {
        int t = 0;
        while (x!=0) {
            if (t > Integer.MAX_VALUE / 10 || t < Integer.MIN_VALUE / 10)  {
                return 0;
            }
            t = t * 10 + (x % 10);
            x = x / 10;
        }
        return t ;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }
}
