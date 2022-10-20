package offer;

/**
 * 删除链表的节点
 */
public class offer18 {
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val)
            return head.next;
        ListNode cur = head;
        ListNode next = head.next;
        while (next!=null && next.val != val) {
            cur = next;
            next = next.next; // 存储的是val
        }
        if (next != null) {
            cur.next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = deleteNode(node1, 9);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
