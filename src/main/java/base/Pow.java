package base;

/**
 * 计算幂次方
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n == -1) {
            return 1 / x;
        }
        double res = myPow(x, n / 2);
        double ans = 0;
        if (n % 2 == 0)
            ans = res * res;
        else {
            ans = n > 0 ? res * res * x : res * res / x;
        }
        return ans;
    }
}
