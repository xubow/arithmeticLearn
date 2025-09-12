package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (环形链表)
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * @date 2025/7/9 08:54
 * @since JDK 1.8
 */
public class CircleList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node2;
        System.out.println(hasCircle(node1));
    }

    /**
     * 弗洛伊德判圈  （快慢指针  如果有闭环 快慢指针会相遇）
     * @param head
     * @return
     */
    public static boolean hasCircle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}