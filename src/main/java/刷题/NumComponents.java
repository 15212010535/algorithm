package 刷题;

import offer.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 链表组件
 */
public class NumComponents {
    public static int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }
        while (head != null) {
            if (set.contains(head.val)) {
                head = head.next;
                while (head != null) {
                    if (set.contains(head.val)) {
                        head = head.next;
                    } else {
                        res++;
                        break;
                    }
                }
            }
            if (head == null) {
                res++;
                break;
            } else {
                head = head.next;
            }
        }
        return res;
    }
}
