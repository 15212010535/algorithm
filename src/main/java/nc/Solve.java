package nc;

/**
 * 大数加法
 */
public class Solve {
    public String solve(String s, String t) {
        // write code here
        int s_len = s.length();
        int t_len = t.length();
        int m = Math.min(s_len, t_len);
        int mod = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            int i1 = s_len > i ? s.charAt(s_len - i) - '0' : 0;
            int i2 = t_len > i ? t.charAt(t_len - i) - '0' : 0;
            int i3 = (i1 + i2 + mod) % 10;
            sb.append(String.valueOf(i3));
            mod = (i1 + i2 + mod) / 10;
        }
        return mod > 0 ? sb.append(mod).reverse().toString() : sb.reverse().toString();
    }
}
