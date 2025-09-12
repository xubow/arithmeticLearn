package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (反转链表2  https://leetcode.cn/problems/reverse-linked-list-ii/description/?envType=problem-list-v2&envId=linked-list)
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 输入  head = [1,2,3,4,5], left = 2, right = 4
 * 输出  [1,4,3,2,5]
 *
 *   left right代表head链表的第几个位置
 *  需要反转节点2，3，4
 * head =1时，链表是[1,2,3,4,5],需要反转当前链表2-4位置节点  left=2 right=4
 * head =2时，链表是[2,3,4,5]，需要反转当前链表1-3位置节点  left=1 right=3
 * head =3时，链表是[3,4,5],需要反转当前链表1-3位置节点    left=1  right=2
 * head =4    ...  left=1 right=1
 * @date 2025/7/17 17:04
 * @since JDK 1.8
 */
public class ReverseLinkedListTwo {


    /**
     * 定义函数： 给定head节点 ，反转left-》right位置上的节点后的链表头节点
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // left right 是左边第几个 右边第几个
        if (left == 1 && right == 1) {
            return head;
        }
        if (left != 1) {
            // left 不等于1 说明head还没到left的位置 head不用反转
            // left-1 && right-1
            head.next = reverseBetween(head.next, left - 1, right - 1);
        } else {
            // left =1时 head需要反转 right-1
            ListNode tail = head.next;
            ListNode newHead = reverseBetween(head.next, left, right - 1);
            // 1   -> 2  -> null
            // head=1时  想要将12反转 可以将行为思考成 把1插在2和null中间
            // => 2 -> 1->null
            head.next = tail.next;
            tail.next = head;
            head = newHead;
        }
return head;
    }
}