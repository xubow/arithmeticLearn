package lee.queueAndStack;

import lee.node.Node;

/**
 * @Author Yves
 * @Data 2023/4/6 下午2:18
 * 链表实现队列和栈
 */
public class DoubleNodeQueueAndStack {
    Node head = null;
    Node tail = null;


    //queue 先进先出  stack 先进后出

    public Node pushFromTailQueue(int value) {
        Node node = new Node(value);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
        }
        return head;
    }
    public Node pushFromHeadQueue(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.pre = node;
        }
        return head;
    }
    public Node pullFromTailQueue() {
        if (tail != null) {
            Node t = tail;
            tail.pre = tail;
            return t;
        }
        return tail;
    }
    public Node pullFromHeadQueue() {
        if (head != null) {
            Node t = head;
            head.next = head;
            return t;
        }
        return head;
    }
}
