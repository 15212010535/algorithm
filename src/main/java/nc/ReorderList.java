package nc;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int size = list.size();
        for (int i = 0; i < (size + 1) >> 1; i++) {
            list.get(i).next = list.get(size - 1 - i);
            if (i == ((size + 1) / 2 - 1)) {
                list.get(size - 1 - i).next = null;
            } else {
                list.get(size - 1 - i).next = list.get(i + 1);
            }
        }
    }
}
