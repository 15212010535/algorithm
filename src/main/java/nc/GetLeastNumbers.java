package nc;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 */
public class GetLeastNumbers {
    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        if (input == null || k == 0) {
            return res;
        }
        for (int j : input) {
            queue.add(j);
        }
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        return res;
    }
}
