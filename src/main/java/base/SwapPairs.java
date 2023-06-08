package base;

import offer.ListNode;

/**
 * 两两交换链表中的相邻点
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        ListNode left = head;
        ListNode right = head.next;
        if (right == null) {
            right = left;
        } else {
            // 两节点交换
            left.next = swapPairs(right.next);
            right.next = left;
        }
        return right;
    }
}
