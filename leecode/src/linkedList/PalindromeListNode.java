package linkedList;

import linkedList.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyves
 * @description: (回文链表 https://leetcode.cn/problems/aMhZSa/description/)
 *
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * @date 2025/7/11 08:56
 * @since JDK 1.8
 */
public class PalindromeListNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(isPalindrome(node1));
    }

    public static boolean isPalindrome(ListNode head) {
        List<ListNode> nodeArr = new ArrayList<>();
        while (head != null) {
            nodeArr.add(head);
            head = head.next;
        }
        // 1 2 3 4
        int pre =0;  int last = nodeArr.size()-1;
        boolean res = true;
        while (pre <= last) {
            if (nodeArr.get(pre).getVal() != nodeArr.get(last).getVal()) {
                res = false;
                break;
            }
            pre ++;
            last --;
        }
        return res;
    }
}