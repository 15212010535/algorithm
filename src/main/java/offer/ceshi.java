package offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ceshi {
    public static int[] aaa(int[] nums, int k, int[] ops) {
        int[] sums = new int[k];
        for (int i = 0; i < k; i++) {
            int finalI = i;
            nums = Arrays.stream(nums).parallel().flatMap((num) -> IntStream.of(num + ops[finalI])).toArray();
            System.out.println(Arrays.toString(nums));
            int sum = Arrays.stream(nums).map(Math::abs).sum();
            sums[i] = sum;
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, -4, 5, 6,-7};
        int[] ops = new int[]{1, -2};
        int[] aaa = aaa(nums, 2, ops);
        System.out.println(Arrays.toString(aaa));
    }
}
