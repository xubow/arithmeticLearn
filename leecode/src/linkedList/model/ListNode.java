package linkedList.model;

import java.beans.Transient;

public class ListNode {
    public int val;

    public ListNode next;

    ListNode() {
    }


    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

    public static void print(ListNode node) {
        while (node !=null) {
            System.out.println(node);
            node = node.next;
        }
    }
}