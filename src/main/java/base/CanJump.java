package base;

/**
 * 跳跃游戏
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        int maxIndex = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxIndex >= i) // 可以跳
                maxIndex = Math.max(maxIndex, i + nums[i]); // 允许的步长
            else
                return false;
        }
        return true;
    }
}
