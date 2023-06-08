package base;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int len = 0;
        int maxLen = 0;
        for (int num : nums) {
            len = 1;
            if (set.remove(num)) {
                int cur = num;
                while (set.remove(--cur)) {
                    len++;
                }
                cur = num;
                while (set.remove(++cur))
                    len++;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
