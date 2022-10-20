package 排序;

import java.util.Arrays;

public class 选择排序 {

    public static void selectSort(int[] arr) {
        // 遍历所有的数
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 把当前遍历的数和后面所有的数进行比较，并记录下最小的数的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 记录最小的数的下标
                    minIndex = j;
                }
            }
            // 如果最小的数的下标和当前遍历的下标不一致，则交换
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 14, 11, 8, 88, 65};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
