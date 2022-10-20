package offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 学到了一个堆栈的创建
 * 从尾到头打印链表
 */
public class offer04 {
//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }

    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        int i = 0;
        while (!stack.empty()) {
            ListNode node = stack.pop();
            res[i] = node.val;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        node2.next = new ListNode(2);
        int[] ints = reversePrint(node1);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
