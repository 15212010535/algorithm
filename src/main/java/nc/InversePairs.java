package nc;

/**
 * 数组中的逆序对
 */
public class InversePairs {
    public int inversePairs(int[] nums) {
        // write code here
        long count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return (int)count % 1000000007;
    }
}
