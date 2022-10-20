package 牛客;


import offer.ListNode;

import java.util.Stack;

public class BM3 {
    public static ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        Stack<ListNode> stack = new Stack<>();
        ListNode newhead = new ListNode(-1);
        ListNode cur = newhead;
        int i = 0;
        while(head != null){
            ListNode temp = head.next;
            head.next = null;
            if (i < k){
                stack.add(head);
            } else {
                while(!stack.isEmpty()){
                    cur.next = stack.pop();
                    cur = cur.next;
                }
                stack.add(head);
                i = 0;
            }
            i++;
            head = temp;
        }
        while (!stack.isEmpty()){
            if (i == k){
                cur.next = stack.pop();
                cur = cur.next;
            } else {
                ListNode node = stack.pop();
                node.next = cur.next;
                cur.next = node;
            }
        }
        return newhead.next;
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
        ListNode listNode = reverseKGroup(node1,2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
        System.out.println(listNode.next.next.next.val);
        System.out.println(listNode.next.next.next.next.val);
    }
}
