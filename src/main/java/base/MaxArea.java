package base;

/**
 * 盛水最多的容器
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            int i = height[left] > height[right] ? right-- : left++;
        }
        return max;
    }
}
