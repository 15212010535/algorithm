package offer;

/**
 * 替换空串
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null)
            return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                sb.append("%20");
            sb.charAt(s.charAt(i));
        }
        return sb.toString();
    }
}
