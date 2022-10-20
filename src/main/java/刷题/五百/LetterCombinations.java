package 刷题.五百;

import java.util.*;

/**
 * 17、电话号码的字母组合
 */
public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        String s = phoneMap.get(digits.charAt(0));
        char[] chars = s.toCharArray();
        for (char c : chars) {
            ans.add(String.valueOf(c));
        }
        for (int i = 1; i < digits.length(); i++) {
            ans = combination(digits.charAt(i), phoneMap, ans);
        }
        return ans;
    }

    public static List<String> combination(char c, Map<Character, String> phoneMap, List<String> ans) {
        // 已有的和当前的组合
        char[] chars = phoneMap.get(c).toCharArray();
        List<String> list = new ArrayList<>();
        for (String an : ans) {
            for (char ch : chars) {
                list.add(an + ch);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
