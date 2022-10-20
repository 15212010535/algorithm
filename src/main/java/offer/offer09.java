package offer;

/**
 * 青蛙跳台阶问题
 */
public class offer09 {
    public static int numWays(int n) {
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;
        int a = 1, b = 2, c = a + b;
        int mod = 1000000007;
        for (int i = 3; i < n; i++) {
            a = b;
            b = c;
            c = (a + b) % mod;
        }
        return c;
    }

    public static void main(String[] args) {
        int ways = numWays(7);
        System.out.println(ways);
    }
}
