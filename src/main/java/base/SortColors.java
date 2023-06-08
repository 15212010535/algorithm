package base;

/**
 * 颜色分类
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int p1 = 0, cur = 0, p2 = nums.length - 1;
        while (cur <= p2) { // 交换不动，在判断
            if (nums[cur] == 0) {
                int tmp = nums[p1];
                nums[p1++] = 0;
                nums[cur++] = tmp;
            } else if (nums[cur] == 2) {
                int tmp = nums[p2];
                nums[p2--] = 2;
                nums[cur] = tmp;
            } else {
                cur++;
            }
        }
    }
}
