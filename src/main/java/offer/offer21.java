package offer;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class offer21 {
    // 多了使用了一个额外的地址，不太好
    public static int[] exchange01(int[] nums) {
        int[] res = new int[nums.length];
        int n = 0;
        int j = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 1) {
                res[n] = num;
                n++;
            } else {
                res[j] = num;
                j--;
            }
        }
        return res;
    }

    // 双指针
    public static int[] exchange02(int[] nums) {
        int tmp, i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] % 2 == 1))
                i++;
            while (i < j && (nums[j] % 2 == 0))
                j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 6, 2, 9, 1};
        System.out.println(Arrays.toString(exchange02(nums)));
    }
}
