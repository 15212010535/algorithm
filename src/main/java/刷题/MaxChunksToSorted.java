package 刷题;

/**
 * 最多能完成排序的块给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * <p>
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 返回数组能分成的最多块数量。
 */
public class MaxChunksToSorted {

    /**
     * 当前值最大值与数组下标相等即可。前i个即可构成一个范围
     * @param arr
     * @return
     */
    public static int maxChunksToSorted(int[] arr) {
        int m = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            System.out.println(m);
            if (m == i) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,2,3,4};
        System.out.println(maxChunksToSorted(nums));
    }
}
