package nc;

/**
 * 链表的奇偶重排
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null)
            return head;
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
