package 刷题;

import java.util.HashMap;
import java.util.Map;

/**
 * 相似度为k的字符串
 */
public class KSimilarity {
    public static int kSimilarity(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int count = 0;
        // 先找出位置不相等的元素。
        // 在位置不相等的元素之间交换。
        return count;
    }

    public static void main(String[] args) {
        String s1 = "aabc";
        String s2 = "abca";
        System.out.println(kSimilarity(s1, s2));
    }
}
