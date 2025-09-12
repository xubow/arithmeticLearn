package linkedList;

import linkedList.model.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyves
 * @description: (复杂链表的复制  https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/description/)
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * @date 2025/7/14 16:51
 * @since JDK 1.8
 */
public class CopyRandomList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node node = copyRandomList(node1);
        print(node);
    }


    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "cur:" + this.val + ",next:" + this.next.val;
        }
    }

    public static void print(Node node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}