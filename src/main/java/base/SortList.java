package base;

import offer.ListNode;

/**
 * 排序链表
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode node = quickSortHelper(head, tail);
            quickSort(head, node);
            quickSort(node.next, null);
        }
        return head;
    }

    private ListNode quickSortHelper(ListNode head, ListNode tail) {
        ListNode p1 = head, p2 = head.next;
        while (p2 != tail) {
            if (p2.val < head.val) {
                p1 = p1.next;
                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }
        if (p1 != head) {
            int tmp = p1.val;
            p1.val = head.val;
            head.val = tmp;
        }
        return p1;
    }
}
