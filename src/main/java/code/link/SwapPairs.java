package code.link;

/**
 * 两两交换链表中的节点
 */
public class SwapPairs {
    public ListNode swapPairsOne(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode newNode = swapPairsOne(next.next);
        next.next = head;  // 移动
        head.next = newNode; // 赋值
        return next;
    }

    public ListNode swapPairsTwo(ListNode head) {
        ListNode dumyhead = new ListNode(-1);
        dumyhead.next = head;
        ListNode cur = dumyhead;
        ListNode temp;
        ListNode firstNode;
        ListNode secondNode;

        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            cur = firstNode;
        }
        return dumyhead.next;
    }
}
