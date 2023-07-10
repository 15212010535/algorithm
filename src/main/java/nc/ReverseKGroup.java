package nc;

/**
 * 链表中的节点每k个一组翻转
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for(int i =0 ; i<k ;i++){
            if(tail == null)
                return head;
            tail = tail.next;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=tail){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = reverseKGroup(tail,k);
        return pre;
    }
}
