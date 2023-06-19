package code.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码组合
 */
public class LetterCombinations {

    List<String> result = new ArrayList<>();

    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return result;
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return result;
    }

    public void backTracking(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String curStr = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < curStr.length(); i++) {
            sb.append(curStr.charAt(i));
            backTracking(digits, numString, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
