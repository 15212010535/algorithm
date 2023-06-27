package code.greedy;

/**
 * 最大子序和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            sum = Math.max(count, sum);
            if (count <= 0)
                count = 0;
        }
        return sum;
    }
}
