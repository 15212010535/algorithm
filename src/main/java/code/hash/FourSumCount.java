package code.hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            for (int n : nums2) {
                int sum = num + n;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int num : nums3) {
            for (int n : nums4) {
                res += map.getOrDefault(-num - n, 0);
            }
        }
        return res;
    }
}
