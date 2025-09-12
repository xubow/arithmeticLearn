package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (K 个一组翻转链表  https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=problem-list-v2&envId=linked-list)
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @date 2025/7/18 19:52
 * @since JDK 1.8
 */
public class ReverseKGroupList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode.print(reverseKGroup(node1, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        // 1->k  1+k->2k  len/k
        int max = len/k;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int i = 0; i < max; i++) {
            dummy.next = reverseBetween(dummy.next, 1+i*k, (i+1)*k);
        }
        return dummy.next;
    }

    /**
     * 反转指定区间的节点
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1 && right == 1) {
            return head;
        }
        if (left != 1) {
            head.next = reverseBetween(head.next, left-1, right -1);
        } else {
            ListNode tail = head.next;
            ListNode newHead = reverseBetween(head.next, left, right -1);
            // 1->2->3  => 2->1->3
            head.next = tail.next;
            tail.next = head;
            head = newHead;
        }
        return head;
    }
}