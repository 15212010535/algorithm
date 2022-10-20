package 刷题;

import offer.ListNode;

/**
 * 两数相加
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(-1);
//        ListNode node = head;
//        int temp = 0;
//        while (l1 != null && l2 != null) {
//            int val = l1.val + l2.val;
//            if (temp != 0) {
//                val = val + 1;
//
//            }
//            if (val >= 10) {
//                val = val - 10;
//                temp = 1;
//            } else {
//                temp = 0;
//            }
//            node.next = new ListNode(val);
//            node = node.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        while (l1 != null && temp != 0) {
//            int val = l1.val + 1;
//            if (val >= 10) {
//                val = val - 10;
//                temp = 1;
//            } else {
//                temp = 0;
//            }
//            node.next = new ListNode(val);
//            node = node.next;
//            l1 = l1.next;
//        }
//        while (l2 != null && temp != 0) {
//            int val = l2.val + 1;
//            if (val >= 10) {
//                val = val - 10;
//                temp = 1;
//            } else {
//                temp = 0;
//            }
//            node.next = new ListNode(val);
//            node = node.next;
//            l2 = l2.next;
//        }
//        if(temp !=0){
//            node.next = new ListNode(temp);
//            node = node.next;
//        } else{
//            node.next = l2!=null? l2 : l1;
//        }
//        return head.next;
        ListNode head = new ListNode(-1);
        ListNode node = head;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            int val = l1val + l2val + temp;
            temp = val / 10;
            val = val % 10;
            node.next = new ListNode(val);
            node = node.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head.next;
    }

}
