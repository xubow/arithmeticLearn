package linkedList;

import linkedList.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenyves
 * @description: (合并 K 个升序链表  https://leetcode.cn/problems/vvXgSW/description/)
 *
 * 给定一个链表数组，每个链表都已经按升序排列。
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @date 2025/7/15 08:46
 * @since JDK 1.8
 */
public class MergeKList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        ListNode a1 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode c1 = new ListNode(5);
        ListNode a2 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode c2 = new ListNode(5);
        a.next = b;
        b.next = c;
        a1.next = b1;
        b1.next = c1;
        a2.next = b2;
        b2.next = c2;
        // 合并多个node
//        ListNode.print(mergeKLists(new ListNode[]{a, a1, a2}));
        // 最小堆输出
        ListNode.print(mergeKListsWithPriorityQueue(new ListNode[]{a, a1, a2}));
    }

    /**
     * 利用最小堆
     * @param lists
     * @return
     */
    public static ListNode mergeKListsWithPriorityQueue(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(ListNode::getVal));
        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list);
                list = list.next;
            }
        }
        ListNode dump = new ListNode(-1), pre = dump;
        while (!queue.isEmpty()) {
            dump.next = queue.poll();
            dump = dump.next;
        }
        return pre.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode list : lists) {
            res = mergeTwoList(res, list);
        }
        return res;
    }

    /**
     * 合并两个有序链表
     * @param nodeA
     * @param nodeB
     * @return
     */
    public static ListNode mergeTwoList(ListNode nodeA, ListNode nodeB) {
        if (nodeA == null) {
            return nodeB;
        }
        if (nodeB == null) {
            return nodeA;
        }
        ListNode pA = nodeA;
        ListNode pB = nodeB;
        ListNode pre = new ListNode(-1), dump = pre;
        while (pA != null && pB != null) {
            if (pA.getVal() <= pB.getVal()) {
                pre.next = pA;
                pA = pA.next;
            } else {
                pre.next = pB;
                pB = pB.next;
            }
            pre = pre.next;
        }

        pre.next = pA != null ? pA :pB;

        return dump.next;
    }

}