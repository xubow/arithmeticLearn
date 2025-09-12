package lee.node;

/**
 * @Author Yves
 * @Data 2023/4/6 上午11:02
 */
public class RemoveNode {

    //删除单向链表中指定value值的节点
    public Node deleteGivenValue(Node head, int value) {
        Node pre,next = null;
        //先筛选出不是value值的head
        while(head != null) {
           if (head.value != value) {
               break;
           }
           head = head.next;
        }
//        while (head != null) {
//            head.next = findNextNodeNotInValue(head, value);
//            head = head.next;
//        }

        //记录不为value值的指针  根据cur去遍历 isNotValue负责去跳过为value值的node
        Node isNotValue = head;
        //用作指针后移
        Node cur = head;
        while(cur != null) {
            if (cur.value == value) {
                //isNotValue节点位置不动，next指向下一个不为value的节点
                isNotValue.next = cur.next;
            } else {
                //将isNotValue跳转到不为value值的当前节点上来
                isNotValue = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    public Node findNextNodeNotInValue(Node head, int value) {
        while (head != null) {
            if (head.value != value) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
