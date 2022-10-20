package 排序;

import java.util.Arrays;

public class 插入排序 {
    public static void insertSort(int[] arr) {
        // 遍历所有
        for (int i = 1; i < arr.length - 1; i++) {
            // 当前数字比前一个数字小
            if (arr[i] < arr[i - 1]) {
                int j;
                // 把当前遍历的数字保存起来
                int temp = arr[i];
                for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                    // 前一个数字复制給后一个数字，数组后移
                    arr[j + 1] = arr[j];
                }
                // 把临时变量赋给不满足条件的后一个元素
                arr[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 14, 11, 8, 88, 65};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
