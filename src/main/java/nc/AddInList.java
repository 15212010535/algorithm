package nc;

/**
 * 链表相加
 */
public class AddInList {
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode newHead1 = reverse(head1);
        ListNode newHead2 = reverse(head2);
        ListNode newHead = new ListNode(-1);
        int carry = 0;
        while (newHead1 != null || newHead2 != null) {
            int head1Val = newHead1 == null ? 0 : newHead1.val;
            int head2Val = newHead2 == null ? 0 : newHead2.val;
            int newVal = (carry + head1Val + head2Val) % 10;
            ListNode nHead = new ListNode(newVal);
            carry = (carry + head1Val + head2Val) / 10;
            nHead.next = newHead.next;
            newHead.next = nHead;
            if (newHead1 != null) {
                newHead1 = newHead1.next;
            }
            if (newHead2 != null) {
                newHead2 = newHead2.next;
            }
        }
        if (carry>0){
            ListNode nHead = new ListNode(carry);
            nHead.next = newHead.next;
            newHead.next = nHead;
        }
        return newHead.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
