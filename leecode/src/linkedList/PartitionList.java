package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: ( 分隔链表  https://leetcode.cn/problems/partition-list/description/?envType=problem-list-v2&envId=linked-list)
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * @date 2025/7/20 15:45
 * @since JDK 1.8
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode.print(partition(node1, 3));
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            // 0 143 252
            // 0 21
            if (head.next.getVal() >= x) {
                head = head.next;
            } else {
                ListNode second = head.next.next;
                head.next.next = pre.next;
                pre.next = head.next;
                head.next = second;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}