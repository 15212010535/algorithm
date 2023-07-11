package nc;

import java.util.PriorityQueue;

/**
 * 单链表排序
 */
public class SortInList {
    public ListNode sortInList(ListNode head) {
        // write code here
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (head != null) {
            queue.add(head.val);
            head = head.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            node.next = new ListNode(num);
            node = node.next;
        }
        return dummy.next;
    }
}
