package offer;

import java.util.Stack;

public class offer24 {
    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        ListNode pop ;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        head = pop = stack.pop();
        while (!stack.empty()){
            node = stack.pop();
            pop.next = node;
            pop = node;
        }
        pop.next = null;
        return head;
    }

    public static ListNode reverseList01(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur!=null){
            // 头插法
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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
        ListNode listNode = reverseList01(node1);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
        System.out.println(listNode.next.next.next.val);
        System.out.println(listNode.next.next.next.next.val);
        System.out.println(listNode.next.next.next.next.next.val);
    }
}
