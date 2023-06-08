package code.link;


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    int size;

    ListNode head;

    public MyLinkedList(){
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index){
        if(index < 0 || index>size)
            return -1;
        ListNode curNode = head;
        for (int i = 0; i <= index; i++) {
            curNode = curNode.next;
        }
        return curNode.val;
    }

    public void addAtHead(int val){
        addAtIndex(0,val);
    }

    public void addAtTail(int val){
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        if (index<0)
            index = 0;
        size++;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    public void deleteIndex(int index){
        if(index < 0 || index>size)
            return;
        size--;
        if(index == 0){
            head = head.next;
            return;
        }
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
