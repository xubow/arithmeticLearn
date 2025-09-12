package sort;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (合并两个有序链表)
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @date 2025/8/17 17:17
 * @since JDK 1.8
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dump = new ListNode(0), tmp = dump;

        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.val < list2.val)) {
                tmp.next = list1;
                list1 = list1.next;
                tmp = tmp.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
                tmp = tmp.next;
            }
        }
        return dump.next;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                tmp.next = list1;
//                list1 = list1.next;
//                tmp = tmp.next;
//            } else {
//                tmp.next = list2;
//                list2 = list2.next;
//                tmp = tmp.next;
//            }
//        }
//        if (list1 == null) {
//            tmp.next = list2;
//        } else {
//            tmp.next = list1;
//        }
//        return dump.next;
    }
}