package linkedList;

import linkedList.model.ListNode;

/**
 * @author chenyves
 * @description: (请在此添加描述)
 * @date 2025/7/10 09:09
 * @since JDK 1.8
 */
public class RotateNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        System.out.println(rotateRight(node1, 2));
        print(rotateRight(node1, 1));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode lenNode = head;
        while (lenNode != null) {
            len ++;
            lenNode = lenNode.next;
        }

        int offset = k%len;

        //模拟一个虚拟头节点
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode q = new ListNode(0);
        q.next = head;

        // 将q节点移动到n+1的位置
        for (int i=0; i<=offset; i++) q = q.next;

        // pq同时往后移动 直到q到达节点 此时p就在需要截取的尾节点的上一个
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        q.next= virtualHead.next;
        virtualHead.next = p.next.next;
        p.next.next = null;
        return virtualHead.next;


    }


    public static void print(ListNode node) {
        while (node !=null) {
            System.out.println(node);
            node = node.next;
        }
    }
}