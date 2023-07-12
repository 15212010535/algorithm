package nc;

import java.util.ArrayList;

/**
 * 数字字符串转化成IP地址
 */
public class RestoreIpAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        if (s.length() > 12)
            return res;
        backTrack(0, 0, s, res);
        return res;
    }

    private void backTrack(int startIndex, int pointNum, String s, ArrayList<String> res) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                res.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backTrack(i + 2, pointNum + 1, s, res);
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end)
            return false;
        if (s.charAt(start) == '0' && start != end)
            return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0')
                return false;
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255)
                return false;
        }
        return true;
    }
}
