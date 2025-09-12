package linkedList;

import linkedList.model.ListNode;

import java.util.Stack;

/**
 * @author chenyves
 * @description: (回文链表  https://leetcode.cn/problems/palindrome-linked-list/description/?envType=problem-list-v2&envId=linked-list)
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @date 2025/7/23 17:43
 * @since JDK 1.8
 */
public class PalindromeList {

    public static void main(String[] args) {
        PalindromeList p = new PalindromeList();
        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(32);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        a.next = c;
//        b.next = c;
        c.next = d;
        System.out.println(p.isPalindrome_two(a));
    }

    /**
     * 放入数组 前后指针对比
     *
     * @return
     */
    public boolean isPalindrome_two(ListNode head) {
        ListNode cur = head;
        StringBuilder sb1 = new StringBuilder();
        while (cur != null) {
            sb1.append(cur.getVal());
            cur = cur.next;
        }
        char[] arr = sb1.toString().toCharArray();
        int pre = 0, last = arr.length-1;
        while (pre <= last) {
            if (arr[pre++] != arr[last--]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 反转链表前后 字符对比
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        StringBuilder sb1 = new StringBuilder();
        while (cur != null) {
            sb1.append(cur.getVal());
            cur = cur.next;
        }

        StringBuilder sb2 = new StringBuilder();
        ListNode node = reverseList(head);
        while (node != null) {
            sb2.append(node.getVal());
            node = node.next;
        }

        return sb1.toString().contentEquals(sb2);
    }

    public ListNode reverseList(ListNode cur) {
        if (cur == null || cur.next == null) {
            return cur;
        }
        ListNode tail = cur.next;
        ListNode newHead = reverseList(cur.next);
        cur.next = tail.next;
        tail.next = cur;
        return newHead;
    }
}