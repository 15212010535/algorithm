package nc;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        if (numbers == null || numbers.length <2){
            return res;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                res[0] = map.get(numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return res;
    }
}
