package linkedList;

import linkedList.model.ListNode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author chenyves
 * @description: (相交链表 https://leetcode.cn/problems/3u1WK4/description/)
 * 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * a1 -> a2 -> a3 -> c1 -> c2
 *       b1 -> b2 -> c1 -> c2
 *
 * @date 2025/7/10 14:09
 * @since JDK 1.8
 */
public class IntersectListNode {



    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
//        print(sortList(a));

    }

    /**
     * 方法1  使用哈希表存储  遍历按两次链表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_one(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return headB;
    }


    /**
     * 方法2 有点意思 把两个链表连接起来 如果有相交 就会在同一长度位置上会相等
     * 如果不相交 最后一个节点都是null
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_two(ListNode headA, ListNode headB) {
       ListNode a = headA;
       ListNode b = headB;
        while (a != b) {
            a = a==null? headB : a.next;
            b = b==null? headA : b.next;
        }
        return a;
    }

    public static void print(ListNode node) {
        while (node !=null) {
            System.out.println(node);
            node = node.next;
        }
    }

}