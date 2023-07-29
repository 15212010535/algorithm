package nc;

/**
 * 移掉 K 位数字
 */
public class RemoveKnums {
    public String removeKnums(String num, int k) {
        // write code here
        int len = num.length();
        if (len == k) {
            return "0";
        }
        char[] chars = num.toCharArray();
        char[] res = new char[len];
        int top = -1;
        int n = len - k;
        for (char c : chars) {
            while (k > 0 && top != -1 && res[top] > c) {
                top--;
                k--;
            }
            res[++top] = c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (sb.length() == 0 && res[i] == '0')
                continue;
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
