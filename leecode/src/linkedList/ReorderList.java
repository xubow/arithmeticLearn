package linkedList;

import linkedList.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyves
 * @description: (重排链表 https://leetcode.cn/problems/LGjMqU/description/)
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *  L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 * @date 2025/7/11 13:53
 * @since JDK 1.8
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
        reorderList_two(node1);
        ListNode.print(node1);
    }

    /**
     * method one
     * 线性表 放入数组中，首尾双指针往中间移动
     * @param head
     */
    public static void reorderList_one(ListNode head) {
        List<ListNode> nodeArr = new ArrayList<>();
        while (head != null) {
            nodeArr.add(head);
            head = head.next;
        }
        int p = 0;
        int q = nodeArr.size()-1;
        while (p < q) {
            // 1 2 3
            // p   q
            nodeArr.get(p).next = nodeArr.get(q);
            p ++;
            if (p == q) {
//                nodeArr.get(p).next = null;
                break;
            }
            nodeArr.get(q).next = nodeArr.get(p);
            q --;
        }
        nodeArr.get(q).next = null;
        head = nodeArr.get(0);
    }


    /**
     * method 2
     * 链表截半 -》后一半反转 -》 两个半链表合并
     * @param head
     */
    public static void reorderList_two(ListNode head) {
        if (head == null || head.next ==null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 当fast走到尾节点 slow走在中间 slow.next 就是第二个半链表的head
        // 1245 => 124 5   => 1524
        // 123456 => 1234 56 => 162534
        ListNode secondHead = slow.next;
        slow.next = null;

        // 二链表反转
        ListNode newSecondHead = reverseList(secondHead);

        //双指针合并
        ListNode firstHead = head;
        while (firstHead !=null && newSecondHead != null) {
            ListNode fnext = firstHead.next;
            firstHead.next = newSecondHead;
            ListNode snext = newSecondHead.next;
            newSecondHead.next = fnext;
            newSecondHead =snext;
            firstHead = fnext;
        }
        if (newSecondHead != null) {
            newSecondHead.next = null;
        }
    }

    public static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        // 1    ->2 ->3
        // 1    ->2 <-3
        //      node
        ListNode newHead = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

}