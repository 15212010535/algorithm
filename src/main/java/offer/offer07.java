package offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class offer07 {
    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;

    public offer07() {
        stack2 = new Stack<>();
        stack1 = new Stack<>();
    }

    // 队尾添加
    public void appendTail(int value) {
        if (stack1 == null) {
            stack1.push(value);
        } else {
            while (!stack1.isEmpty()) {
                Integer v = stack1.pop();
                stack2.push(v);
            }
            stack1.push(value);
            while (!stack2.isEmpty()) {
                Integer v = stack2.pop();
                stack1.push(v);
            }
        }
    }

    public int deleteHead() {
        return stack1.isEmpty() ? -1 : stack1.pop();
    }
}
