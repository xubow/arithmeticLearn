package lee.node;

/**
 * @Author Yves
 * @Data 2023/4/6 上午10:28
 */
public class Node {

    public Node pre;
    public Node next;

    int value;

    public Node(int value) {
        this.value = value;
    }

      public  class InnerNode {
        int num;
    }

}
