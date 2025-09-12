package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (扁平化多级双向链表  https://leetcode.cn/problems/Qv1Da2/description/)
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 *
 * e.g.
 * 1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * =>  [1,2,3,7,8,11,12,9,10,4,5,6]
 * @date 2025/7/15 10:58
 * @since JDK 1.8
 */
public class FlattenList {


//    public static ListNode flatten(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        head.next = flatten(head.next);
//        return head;
//    }
}