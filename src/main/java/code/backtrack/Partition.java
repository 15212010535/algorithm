package code.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 */
public class Partition {

    List<List<String>> ans = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return ans;
    }

    public void backTracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String substring = s.substring(startIndex, i + 1);
                deque.addLast(substring);
            } else {
                continue;
            }
            backTracking(s, i + 1);
            deque.removeLast();
        }
    }

    public boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
