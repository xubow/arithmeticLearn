package search;

import java.util.Random;

/**
 * @author chenyves
 * @description: (跳表) 时间复杂度O(logN)
 *
 * -n ->           3 ->      5 -> n
 * -n ->      2 -> 3 ->      5 -> n
 * -n -> 1 -> 2    3 ->      5 -> n
 * -n -> 1 -> 2 -> 3 -> 4 -> 5 -> n
 *
 * -n,n为两个边界，代表最小值和最大值
 * 从左上角的-n节点开始查询值n，
 * 如果node.next.val < n ，继续在当前层往后寻找 node=node.next
 * 如果 node.next.val >= n ，则往下一层寻找 node=node.down
 *
 * @date 2025/8/22 16:05
 * @since JDK 1.8
 */
public class SkipList {

    Node head;
    Node tail;
    Integer maxLevel;

    // 只是用来随机插入值的level
    Random random;


    public static void main(String[] args) {
        Node node = new SkipList().initNode(5, 4);
        while (node != null) {
            System.out.println(node.val);
            node = node.down;
        }
    }

    public void insert(int val) {
        int level = random.nextInt();

    }

    /**
     * 初始化skipList
     * @param n
     */
     public void initSkipList(int n) {
         this.maxLevel = n;
         random = new Random(n);
         head = initNode(-maxLevel, maxLevel);
         tail = initNode(maxLevel, maxLevel);
         while (head.down != null) {
             head.next = tail;
             head = head.down;
             tail = tail.down;
         }
     }

    /**
     * 初始化Node
     * @param val 值
     * @param n 个数，也代表有几层
     * @return node 返回最顶层的node节点
     */
    public Node initNode(int val, int n) {
        Node btm = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.val = val;
            node.level = i;
            node.down = btm;
            btm = node;
        }
        return btm;
    }



    class Node {
        int val;
        /**
         * 层数 最下面为0层
         */
        int level;
        Node next;
        Node down;
    }

}