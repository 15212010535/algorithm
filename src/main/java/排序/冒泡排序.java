package 排序;

import java.util.Arrays;

/**
 * 原理：
 * 1、 比较相邻的元素。如果第一个比第二个大，就交换
 * 2、 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对，最后的元素即为最大的数
 * 3、 针对所有的元素重复以上的步骤，除了最后一个。
 * 4、 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * <p>
 * 时间复杂度：
 * 最好: O(n) 最坏: O(n^2) 平均: O(n^2)
 * <p>
 * 空间复杂度：
 * O(1)
 * <p>
 * 稳定性：
 * 稳定的排序算法
 */

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 11, 21, 88, 65};

        // 从小到大排序
        for (int i = 0; i < nums.length - 1; i++) {
            // 设计一个标记，用来加快遍历。不需要遍历所有。
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }
        System.out.println(Arrays.toString(nums));

        // 从大到小
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
