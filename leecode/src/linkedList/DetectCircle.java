package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (环形链表2 https://leetcode.cn/problems/c32eOV/description/)
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。
 * 如果链表无环，则返回 null。
 * @date 2025/7/11 17:29
 * @since JDK 1.8
 */
public class DetectCircle {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 本题需要得到环的第一个node
            // 思路： 在相遇点，慢指针回到起点 然后与快指针同步往前，再次相遇的点就是环的起点
            if (slow == fast) {
                slow = head;
                while (slow != fast && fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

}