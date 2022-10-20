package offer;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 链表中倒数第k个结点
 */
public class offer22 {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        for (int i = 0; i < k; i++) {
            node = stack.pop();
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        getKthFromEnd(node1, 2);
    }
}
