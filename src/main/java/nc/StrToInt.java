package nc;


/**
 * 把字符串转换成整数(atoi)
 */
public class StrToInt {
    public int strToInt(String s) {
        // write code here
        int res = 0, val = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, len = s.length();
        if (len == 0)
            return 0;
        while (s.charAt(i) == ' ') {
            if (++i == len) {
                return 0;
            }
        }
        if (s.charAt(i) == '-') {
            sign = -1;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+')
            ++i;
        for (int j = i; j < len; j++) {
            if (s.charAt(j) - '0' < 0 || s.charAt(j) - '0' > 9)
                break;
            if (res > val || res == val && s.charAt(j) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(j) - '0');
        }
        return res * sign;
    }
}
