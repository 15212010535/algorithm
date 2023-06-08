package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len == 0)
            return res;
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                dp[left][right] = charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1]);
            }
        }
        LinkedList<String> path = new LinkedList<>();
        dfs(s, 0, res, path, dp);
        return res;
    }

    private void dfs(String s, int start, List<List<String>> res, LinkedList<String> path, boolean[][] dp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                path.addLast(s.substring(start, i + 1));
                dfs(s, i + 1, res, path, dp);
                path.removeLast();
            }
        }
    }
}
