package code.greedy;

/**
 * 跳跃游戏 II
 */
public class Jump {
    public int jump(int[] nums) {
        int result = 0;
        int end = 0;
        int temp = 0;
        for (int i = 0; i <= end && end < nums.length - 1; i++) {
            temp = Math.max(temp, i + nums[i]);
            if (i == end) {
                end = temp;
                result++;
            }
        }
        return result;
    }
}
