package tree.sortTree;

import sort.util.ArrUtil;

/**
 * @author chenyves
 * @description: ( 二叉排序树 )
 *
 * @date 2025/8/30 19:11
 * @since JDK 1.8
 */
public class SortTree {


    public static void main(String[] args) {
        SortTree sortTree = new SortTree();
//        int[] arr = ArrUtil.randomArr(10);
        int[] arr = new int[]{40, 31, 59, 96, 14, 37, 95, 97, 17, 70};
        ArrUtil.printArr(arr);
        Node head = null;
        for (int num : arr) {
            head = sortTree.insert(head, num);
        }
        sortTree.printTree(head);

        Node search = sortTree.search(head, 18);
        if (search == null) {
            System.out.println(-1);
        } else {
            System.out.println(search.val);
        }
//        System.out.println("--------------");
//        head = sortTree.delete(head, 97);
//        sortTree.printTree(head);
//
//        System.out.println("--------------");
//        head = sortTree.delete(head, 14);
//        sortTree.printTree(head);

        System.out.println("--------------");
        head = sortTree.erase(head, 40);
        sortTree.printTree(head);

    }

    /**
     *  初始化一个node节点
     * @param key
     * @return
     */
    Node getNewNode(int key) {
        Node node = new Node();
        node.val = key;
        node.lChild = node.rChild = null;
        return node;
    }

    /**
     * 将一个key值插入树中
     * 二叉排序树  左孩子的值小于头节点 右孩子大于头节点
     * @param head
     * @param key
     * @return
     */
    Node insert(Node head, int key) {
        Node curNode = getNewNode(key);
        if (head == null) return curNode;
        if (head.val == key) return head;
        if (head.val < key) {
           head.rChild = insert(head.rChild, key);
        } else {
            head.lChild = insert(head.lChild, key);
        }
       return head;
    }

    /**
     * 查找key值的节点
     * @param head
     * @param key
     * @return
     */
    Node search(Node head, int key) {
        if (head == null) return null;
        if (head.val == key) return head;
        if (head.val > key) return search(head.lChild, key);
        return search(head.rChild, key);
    }

    /**
     * 删除值为key的节点
     *    4
     * 2      7
     *  3   6   8
     *  中序遍历  [2,3,4,6,7,8]
     *
     * 1. 出度为0 说明没有子节点 直接删除
     * 2. 出度为1 子节点变为该节点
     * 3. 出度为2
     *      找到该节点的前驱或者后继 （中序遍历后的前后位置的值 ）等价于 (左子树中的最大值 和 右子树中的最小值)
     *      将该节点和前驱或者后继节点值交换 ，然后在相应子树中删除其前驱或者后继节点
     *          （注意此时删除会再进行一次出度1的删除操作，以前驱为例，前驱节点必定是左子树中最右的节点，不会有右子树，出度为0或者1）
     * @param head
     * @param key
     * @return 返回删除后的头节点
     */
    Node erase(Node head, int key) {
        if (head == null) return head;
        if (head.val == key) {
            // 度为0
            if (head.lChild == null && head.rChild == null) {
                head = null;
                return head;
            }
            // 度为1
            if (head.lChild == null || head.rChild == null) {
                head = head.lChild == null ? head.rChild : head.lChild;
                head.lChild = head.rChild = null;
            } else {
                // 度为2
                // 找到前驱
                Node processor = findProcessor(head);
                // 将前驱的值赋给当前节点
                head.val = processor.val;
                // 在当前节点左子树中 删除前驱节点
                head.lChild = erase(head.lChild, processor.val);
            }
        } else if (head.val > key) {
            head.lChild = erase(head.lChild, key);
        } else {
            head.rChild = erase(head.rChild, key);
        }
        return head;
    }

    /**
     * 找当前节点的前驱
     * @param node
     * @return
     */
    Node findProcessor(Node node) {
        Node left = node.lChild;
        while (left.rChild != null) {
            left = left.rChild;
        }
        return left;
    }

    void printTree(Node head) {
        if (head == null) return;
        System.out.println("[" + head.val + "] " + "(" + (head.lChild == null ? -1: head.lChild.val) + ", " +  (head.rChild == null ? -1: head.rChild.val) + ")");
        printTree(head.lChild);
        printTree(head.rChild);
    }


    class Node {
        int val;
        Node lChild;
        Node rChild;
    }



}