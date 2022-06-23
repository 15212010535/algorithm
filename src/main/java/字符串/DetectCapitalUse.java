package 字符串;

/**
 * 检测大写字母
 *
 *  全部字母都是大写，比如 "USA" 。
 *  单词中所有字母都不是大写，比如 "leetcode" 。
 *  如果单词不只含有一个字母，只有首字母大写，比如"Google"
 *
 *  还有一种解题思路是统计出大写或者小写字符的个数与字符串长度进行比较
 *
 * */
public class DetectCapitalUse {

    public static boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        boolean flag = true;
        if (chars.length == 1) {
            return true;
        }
        if (chars[0] <= 90 && chars[0] >= 60) {
            if (chars[1] <= 90 && chars[1] >= 60) {
                for (int i = 2; i < chars.length; i++) {
                    if (chars[i] <= 122 && chars[i] >= 97) {
                        flag = false;
                        break;
                    }
                }
            } else {
                for (int i = 2; i < chars.length; i++) {
                    if (chars[i] <= 90 && chars[i] >= 60) {
                        flag = false;
                        break;
                    }
                }
            }

        } else {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] <= 90 && chars[i] >= 60) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String word = "L";
        boolean b = detectCapitalUse(word);
        System.out.println(b);
    }
}
