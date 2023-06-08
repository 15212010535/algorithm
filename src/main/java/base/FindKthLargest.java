package base;

import java.util.PriorityQueue;

/**
 * 数组中的第k个最大元素
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            queue.add(num);
        }
        int cur = queue.poll();
        --k;
        while (k != 0) {
            cur = queue.poll();
            --k;
        }
        return cur;
    }

    public static void main(String[] args) {
        findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }
}
