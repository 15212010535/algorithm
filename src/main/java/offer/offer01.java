package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中重复的数字
 */
public class offer01 {
    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return i;
            } else
                map.put(nums[i], 0);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(arr);
        System.out.println(repeatNumber);
    }
}
