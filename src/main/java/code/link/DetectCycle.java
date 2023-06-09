package code.link;

/**
 * 环形链表
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index2 != index1) {
                    index2 = index2.next;
                    index1 = index1.next;
                }
                return index1;
            }
        }
        return null;
    }
}
