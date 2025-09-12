package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (删除链表的节点 https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/description/)
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * @date 2025/7/14 16:41
 * @since JDK 1.8
 */
public class DeleteNode {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode.print(deleteNode(node1, 1));

    }

    /**
     * 链表具有递归性质  头节点 + 一个短链表
     * 从尾部开始删除
     *
     * 定义函数： 返回短链表head
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 当前链表
        head.next = deleteNode(head.next, val);
        // 当前节点如果是需要删除的  则返回head的next  用于上一层的节点+短链表拼接
        return head.getVal() == val ? head.next : head;
    }
}