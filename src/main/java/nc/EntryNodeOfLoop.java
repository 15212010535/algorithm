package nc;

/**
 * 链表中环的入口结点
 */
public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode s = pHead;
                ListNode f = fast;
                while (s != f) {
                    s = s.next;
                    f = f.next;
                }
                return f;
            }
        }
        return null;
    }
}
