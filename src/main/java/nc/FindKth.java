package nc;

import java.util.Arrays;

/**
 * 寻找第K大
 */
public class FindKth {
    public int findKth(int[] a, int n, int K) {
        Arrays.sort(a);
        return a[n - K + 1];
    }
}
