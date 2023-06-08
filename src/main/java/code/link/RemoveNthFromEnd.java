package code.link;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;
        for (int i = 0; i < n; i++) {
            fastIndex = fastIndex.next;
        }
        while (fastIndex.next != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;

    }
}
