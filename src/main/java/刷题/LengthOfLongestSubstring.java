package 刷题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int size = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer integer = map.get(chars[i]);
            if (integer == null) {
                map.put(chars[i], i);
            } else {
                size = Math.max(size, map.size());
                map.clear();
                i = integer;
            }
        }
        return Math.max(size, map.size());
    }

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }
}
