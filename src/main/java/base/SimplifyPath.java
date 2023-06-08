package base;

import java.util.Stack;

/**
 * 简化路径
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            if (!"".equals(str) && !".".equals(str)) {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stack) {
            stringBuilder.append("/").append(s);
        }
        return stringBuilder.toString();
    }
}
