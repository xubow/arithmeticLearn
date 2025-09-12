package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (链表求和  https://leetcode.cn/problems/sum-lists-lcci/description/)
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果
 * @date 2025/7/15 16:40
 * @since JDK 1.8
 */
public class AddTwoNum {
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode a1 = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode c1 = new ListNode(4);
        a.next = b;
        b.next = c;
        a1.next = b1;
        b1.next = c1;

        ListNode.print(addTwoNumbers(a, a1));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1 5 7
        // 3 6 7
        ListNode dump = new ListNode(0), pre = dump;
        // 是否需要进位
        boolean needIncrease = false;
        while (l1 != null && l2 != null) {
            int val = l1.getVal() + l2.getVal();
            if (needIncrease) {
                val += 1;
            }
            needIncrease = val >= 10;
            ListNode cur = new ListNode(val%10);
            dump.next = cur;
            dump = cur;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.getVal();
            if (needIncrease) {
                val += 1;
            }
            needIncrease = val >= 10;
            ListNode cur = new ListNode(val%10);
            dump.next = cur;
            dump = cur;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.getVal();
            if (needIncrease) {
                val += 1;
            }
            needIncrease = val >= 10;
            ListNode cur = new ListNode(val%10);
            dump.next = cur;
            dump = cur;
            l2 = l2.next;
        }
        if (needIncrease) {
            ListNode cur = new ListNode(1);
            cur.next = null;
            dump.next = cur;
        }
        return pre.next;
    }
}