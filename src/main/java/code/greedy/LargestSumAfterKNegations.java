package code.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * K 次取反后最大化的数组和
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int K) {
        nums = IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        if (K % 2 == 1)
            nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();
    }
}
