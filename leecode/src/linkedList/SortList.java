package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (排序链表  https://leetcode.cn/problems/sort-list/description/)
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * @date 2025/7/16 14:17
 * @since JDK 1.8
 */
public class SortList {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode.print(sortList(node1));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        ListNode[] nodeArr = new ListNode[len];
        int i = 0;
        cur = head;
        while (cur != null) {
            nodeArr[i ++] = cur;
            cur = cur.next;
        }
        ListNode[] nodes = sortAndMerge(nodeArr, 0, len-1);
        ListNode pre = new ListNode(-1), dump = pre;
        for (ListNode node : nodes) {
            pre.next = node;
            pre = pre.next;
        }
        pre.next = null;
        return dump.next;

    }

    public static ListNode[] sortAndMerge(ListNode[] arr, int left, int right) {
        if (left == right) {
            return new ListNode[]{arr[left]};
        }
        int mid = left + ((right - left) >> 1);
        ListNode[] larr = sortAndMerge(arr, left, mid);
        ListNode[] rarr = sortAndMerge(arr, mid +1, right);
        return merge(larr, rarr);
    }

    public static ListNode[] merge(ListNode[] l, ListNode[] r) {
        ListNode[] resArr = new ListNode[l.length+r.length];
        int p =0, q = 0, i = 0;
        while (p<l.length && q <r.length) {
            if (l[p].getVal() <= r[q].getVal()) {
                resArr[i] = l[p];
                p ++;
            } else {
                resArr[i] = r[q];
                q ++;
            }
            i ++;
        }
        while (p<l.length) {
            resArr[i ++] = l[p++];
        }
        while (q<r.length) {
            resArr[i ++] = r[q++];
        }
        return resArr;
    }

}