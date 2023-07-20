package nc;

/**
 * 环形链表的约瑟夫问题
 */
public class YSF {
    public int ysf(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res + 1;
    }
}
