package code.stackQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String s : tokens) {
            if ("+" .equals(s)) {
                deque.push(deque.pop() + deque.pop());
            } else if ("-" .equals(s)) {
                deque.push(-deque.pop() + deque.pop());
            } else if ("*" .equals(s)) {
                deque.push(deque.pop() * deque.pop());
            } else if ("/" .equals(s)) {
                Integer t1 = deque.pop();
                Integer t2 = deque.pop();
                deque.push(t2 / t1);
            } else {
                deque.push(Integer.valueOf(s));
            }
        }
        return deque.pop();
    }
}
