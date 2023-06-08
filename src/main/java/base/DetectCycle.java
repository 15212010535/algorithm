package base;

import offer.ListNode;

/**
 * 环形链表II
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        // 相遇
        fast = head;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
