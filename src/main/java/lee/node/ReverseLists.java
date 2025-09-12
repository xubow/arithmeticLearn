package lee.node;

/**
 * @Author Yves
 * @Data 2023/4/6 上午10:27
 */
public class ReverseLists {

    public static void main(String[] args) {

    }

    private Node reverseSingleList(Node head) {
        Node pre = null;
        Node next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            //head指针后移
            pre = head;
            head = next;
        }
        return pre;
    }

    private Node reverseDoubleList(Node head) {
        Node pre = null;
        Node next = null;
        while(head != null) {
            next = head.next;

            head.next = pre;
            head.pre = next;

            pre = head;
            //head指针后移
            head = next;
        }
        return pre;
    }
}
