package base;

import offer.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode tmp = ans;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tmp.next = l2;
                l2 = l2.next;
            } else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;
        return ans.next;

    }
}
