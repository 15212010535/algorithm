package base;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 发现有重复元素
            if (map.containsKey(s.charAt(i))) {
                // 获取重复元素位置
                Integer index = map.get(s.charAt(i));
                left =  Math.max(left,index + 1);
            }
            // 不重复一直放入
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }
}
