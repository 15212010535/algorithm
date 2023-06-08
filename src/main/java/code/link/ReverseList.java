package code.link;

/**
 * 翻转链表
 */
public class ReverseList {

    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public ListNode reverseListOne(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) { // 头插法
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return head;
    }

    public ListNode reverseListTwo(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null)
            return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }
}
