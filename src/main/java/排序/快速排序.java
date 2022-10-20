package 排序;

import java.util.Arrays;

public class 快速排序 {

    public static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            // 把数组中首位数字作为基准数
            int st = arr[start];
            // 记录需要排序的下标
            int low = start;
            int high = end;
            // 循环找到比基准数大的数和比基准数小的数
            while (low < high) {
                // 右边的数比基准数大
                while (low < high && arr[high] >= st) {
                    high--;
                }
                // 使用右边的数替换左边的数
                arr[low] = arr[high];
                // 左边的数比基准数小
                while (low < high && arr[low] <= st) {
                    low++;
                }
                // 使用左边的数替换右边的数
                arr[high] = arr[low];
            }
            // 把基准值复制给下标重合的值
            arr[low] = st;
            // 处理所以下的数字
            quicksort(arr, start, low);
            // 处理所有大的数字
            quicksort(arr, low + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 11, 21, 88, 65};
        quicksort(nums, 0, 5);
        System.out.println(Arrays.toString(nums));
    }
}
