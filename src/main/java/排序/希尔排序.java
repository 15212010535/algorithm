package 排序;

import java.util.Arrays;

public class 希尔排序 {

    public static void shellSort(int[] arr) {
        // gap 为步长，每次减为原来的一半
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 对本组数据执行直接插入排序
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j += gap) {
                    // 如果a[j] < a[j-gap], 则寻找a[j]位置，并将后面数据的位置后移
                    if (arr[j] < arr[j - gap]) {
                        int k;
                        int temp = arr[j];
                        for (k = j - gap; k >= 0 && arr[k] > temp; k -= gap) {
                            arr[k + gap] = arr[k];
                        }
                        arr[k + gap] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 14, 11, 8, 88, 65};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
