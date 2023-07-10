package nc;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复数组
 */
public class MaxLength {
    public int maxLength(int[] arr) {
        // write code here
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, index = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                index = Math.max(index, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            max = Math.max(max, i - index + 1);
        }
        return max;
    }
}
