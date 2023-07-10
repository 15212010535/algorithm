package nc;

/**
 * 合并两个排序的链表
 */
public class Merge {
    public ListNode merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        if (pHead1 == null && pHead2 != null)
            return pHead2;
        if (pHead2 == null && pHead1 != null)
            return pHead1;
        ListNode temp = new ListNode(-1);
        ListNode node = temp;
        while (pHead1 !=null && pHead2 !=null){
            if (pHead1.val > pHead2.val){
                node.next = pHead2;
                pHead2 = pHead2.next;
            }else {
                node.next = pHead1;
                pHead1 = pHead1.next;
            }
            node = node.next;
        }
        if (pHead1 == null)
            node.next = pHead2;
        else
            node.next = pHead1;
        return temp.next;
    }
}
