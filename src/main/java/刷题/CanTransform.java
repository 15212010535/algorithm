package 刷题;

/**
 * 在LR字符串中交换相邻字符
 */
public class CanTransform {
    public static boolean canTransform(String start, String end) {
        if (start.length() == 1) {
            return start.charAt(0) == end.charAt(0);
        }
        return transformer(start, end);
    }

    public static boolean transformer(String s, String e) {
        // 递归出口
        if (s.length() == 2) {
            if (s.charAt(0) == e.charAt(0)) {
                return s.charAt(1) == e.charAt(1);
            } else if (s.startsWith("XL") || s.startsWith("RX")) {
                return s.charAt(0) == e.charAt(1) && s.charAt(1) == e.charAt(0);
            } else {
                return false;
            }
        }

        if (s.charAt(0) == e.charAt(0)) {
            return transformer(s.substring(1), e.substring(1));
        } else if (s.startsWith("XL") || s.startsWith("RX")) {
            if (s.charAt(0) == e.charAt(1) && s.charAt(1) == e.charAt(0)) {
                return transformer(s.substring(2), e.substring(2));
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }
}
