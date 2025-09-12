package sort;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (链表排序)
 * https://leetcode.cn/problems/sort-list/
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
 *
 * @date 2025/8/14 10:58
 * @since JDK 1.8
 */
public class SortList {


    public static void main(String[] args) {
//        System.out.println(5 >> 1);

        int[] arr = new int[]{4,19,14,5,-3,1,8,5,11,15};
        ListNode head = new ListNode(4), dump = head;
        for (int i = 1; i < arr.length; i++) {
            dump.next = new ListNode(arr[i]);
            dump = dump.next;
        }
        ListNode node = new SortList().sortList_Quick(head);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }


    /**
     * 快速排序
     * 找到基准值 -> 进行分区 -> 递归
     * @param head
     * @return
     */
    public ListNode sortList_Quick(ListNode head) {
        // 找基准值可以取中间值，这样树的高度就会最小，nLogn
        if (head == null || head.next == null) {
            return head;
        }
        int max = head.val, min = head.val;
        ListNode cur  = head;
        while (cur != null) {
            max = Math.max(max, cur.val);
            min = Math.min(min, cur.val);
            cur = cur.next;
        }
        // 如果最小=最大 说明都是同值
        if (min == max) {
            return head;
        }
        // 确定中间值作为基准值
        int radix = min + ((max - min) >> 1);

        // 定义两个链表 分别存放小于等于基准值的节点和大于基准值的节点
        ListNode small = null, big = null;

        cur = head;
        while (cur != null) {
            // 采用头插法 会使cur的next指针改变，所以提前取到next的值
            ListNode next = cur.next;
            if (cur.val <= radix) {
                cur.next = small;
                small = cur;
            } else {
                cur.next = big;
                big = cur;
            }
            cur = next;
        }
        // 分别递归小链表和大链表 让其有序
        ListNode s = sortList_Quick(small);
        ListNode b = sortList_Quick(big);
        // 拼接两个有序链表
        cur = s;
        // 找到小链表尾节点
        while (cur.next != null) cur = cur.next;
        // 拼接大链表头节点
        cur.next = b;
        // 返回小链表头节点
        return s;
    }

    /**
     * 归并排序
     * 找到中间位置，分为两个区间
     * @param head
     * @return
     */
    public ListNode sortList_Merge(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            if (head.next.val < head.val) {
                // swap
                ListNode next = head.next;
                next.next = head;
                head.next = null;
                return next;
            } else {
                return head;
            }
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode fst = sortList_Merge(head);
        ListNode sec = sortList_Merge(mid);
        ListNode pre = new ListNode(-1), preCopy = pre;
        while (fst != null && sec != null) {
            if (fst.val < sec.val) {
                pre.next = fst;
                fst = fst.next;
            } else {
                pre.next = sec;
                sec = sec.next;
            }
            pre = pre.next;
        }

        if (fst != null) {
            pre.next = fst;
        }
        if (sec != null) {
            pre.next = sec;
        }
        return preCopy.next;
    }
}