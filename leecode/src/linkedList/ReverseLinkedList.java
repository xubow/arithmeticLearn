package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (反转链表 https://leetcode.cn/problems/reverse-linked-list/)
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @date 2025/7/2 10:02
 * @since JDK 1.8
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
       node1.next = node2;
       node2.next = node3;
       node3.next = node4;
       ListNode head = reverseList_twoPoints(node1);
       while (head != null) {
           System.out.println(head.getVal());
           head = head.next;
       }
    }


    /**
     * first method
     * 递归
     * @param head
     * @return
     */
    public static ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 这边返回的新头节点就是原链表的尾节点
        ListNode newHead = reverseList_recursive(head.next);
        // 1->2->3->4
        // 1->2->3<-4
        // 假设34节点已经反转完成 当前到了2节点  需要将3节点的next指向2,2的next指向空
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    /**
     * second method
     * 双指针
     * null  1->2->3->4
     * @param head
     * @return
     */
    public static ListNode reverseList_twoPoints(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // cur=null退出循环，所以pre就是原链表最后一个节点 作为新的head
        return pre;
    }


}