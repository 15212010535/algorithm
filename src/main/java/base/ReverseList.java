package base;

import offer.ListNode;

import java.util.List;

/**
 * 反转链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head ==null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur!=null){ // 头插法
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
