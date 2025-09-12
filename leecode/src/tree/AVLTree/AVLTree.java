package tree.AVLTree;

import sort.util.ArrUtil;

/**
 * @author chenyves
 * @description: (AVL树)
 *
 * 排序二叉树在插入过程中 很容易退化成单链表
 *
 * 平衡二叉树（规定某些条件）
 * AVL树的性质：
 *  左右子树的高度差 <= 1
 *
 *  失衡类型：(左右子树的高度差大于1，通过左右旋转调整当前树的左右子树高度)
 *     对从下往上找的第一个失衡的节点进行调整
 *  LL 左子树的左子树的高度更高  对head节点进行右旋
 *  LR 左子树的右子树的高度更高  对head节点的左节点左旋，再对head右旋
 *  RR 右子树的右子树的高度更高  对head节点进行左旋
 *  RL 右子树的左子树的高度更高  对head节点的右节点右旋，再对head左旋
 *  其中 LL 与 RR 对称， LR和RL对称
 *
 *
 * @date 2025/8/30 20:31
 * @since JDK 1.8
 */
public class AVLTree {

    static Node NIL;
    static {
        // 定义空节点
        NIL = new Node();
        NIL.val = -1;
        NIL.height = 0;
        NIL.left = NIL.right = NIL;
    }

    public static void main(String[] args) {
        AVLTree instance  = new AVLTree();
        int[] arr = new int[]{84, 4, 41, 82, 49, 11, 9, 40, 24, 79};
        ArrUtil.printArr(arr);
        Node head = NIL;
        for (int num : arr) {
            head = instance.insert(head, num);
        }
        instance.printTree(head);

        System.out.println("------------");
        head = instance.erase(head, 24);
        instance.printTree(head);
    }

    /**
     * 删除节点
     * @param head
     * @param key
     * @return 返回删除后的树头节点
     */
    Node erase(Node head, int key) {
        if (head == NIL) return head;
        if (head.val == key) {
            // 出度0
            if (head.left == NIL && head.right == NIL) {
                head = NIL;
            }
            // 出度1
            if (head.left == NIL || head.right == NIL) {
                head = head.left == NIL ? head.right : head.left;
            }
            // 出度2
            if (head.left != NIL && head.right != NIL) {
                Node processor = findProcessor(head);
                head.val = processor.val;
                head.left = erase(head.left, processor.val);
            }
        } else if (head.val > key) {
            // 从左子树中删除
            head.left = erase(head.left, key);
        } else {
            // 从右子树中删除
            head.right = erase(head.right, key);
        }
        updateNodeHeight(head);
        return maintain(head);
    }


    Node insert(Node head, int key) {
        if (head == NIL) return getNewNode(key);
        if (key == head.val) return head;
        if (key < head.val) head.left = insert(head.left, key);
        if (key > head.val) head.right = insert(head.right, key);
        // 插入节点后 当前head节点的高度就会有变化
        updateNodeHeight(head);
        // 如果当前节点出现失衡 进行调整
        return maintain(head);
    }

    /**
     * 解决节点失衡
     * @param head
     * @return
     */
    Node maintain(Node head) {
        // 左右子树高度差小于等于1 说明没有失衡 不用调整
        if (Math.abs(head.left.height - head.right.height) <= 1) return head;
        // 左子树高 (LL, LR)
        if (head.left.height > head.right.height) {
            // LR
            // 先对head.left子树进行左旋
            if (head.left.right.height > head.left.left.height) {
                head.left = leftRotate(head.left);
            }
            // head节点进行右旋
            head = rightRotate(head);
        }
        // 右子树高 （RR, RL）
        if (head.right.height > head.left.height) {
            // RL
            // 先对head.right进行右旋
            if (head.right.left.height > head.right.right.height) {
                head.right = rightRotate(head.right);
            }
            // head节点进行zuo旋
            head = leftRotate(head);
        }
        return head;
    }

    /**
     * 找前驱节点(中序遍历的前一个元素)
     * @param head
     * @return
     */
    Node findProcessor(Node head) {
        Node left = head.left;
        while (left.right != NIL) {
            left = left.right;
        }
        return left;
    }

    /**
     * 计算当前的高度 = 左右子树较高的高度 + 1
     * @param node
     */
    void updateNodeHeight(Node node) {
        int lh = node.left.height;
        int rh = node.right.height;
        node.height = Math.max(lh, rh) + 1;
    }

    /**
     * 左旋
     *      4                7
     *   2      7   =》   4
     *        6         2  6
     * @param head
     * @return
     */
    Node leftRotate(Node head) {
        Node tmp = head.right;
        // 原头节点的右子节点变为右节点的左节点
        head.right = tmp.left;
        // 原头节点的右子节点的左节点变为原头节点
        tmp.left = head;
        // !!!!此处旋转之后一定要重新更新head和新head的高度
        updateNodeHeight(head);
        updateNodeHeight(tmp);
        return tmp;
    }

    /**
     * 右旋转
     * @param head
     * @return
     */
    Node rightRotate(Node head) {
        Node tmp = head.left;
        head.left = tmp.right;
        tmp.right = head;
        updateNodeHeight(head);
        updateNodeHeight(tmp);
        return tmp;
    }

    Node getNewNode(int key) {
        Node node = new Node();
        node.val = key;
        node.left = node.right = NIL;
        node.height = 1;
        return node;
    }

    void printTree(Node head) {
        if (head == NIL) return;
        System.out.println("[" + head.val + "] " + "(" + ( head.left.val) + ", " +  (head.right.val) + ")");
        printTree(head.left);
        printTree(head.right);
    }


    static class Node {
        int val;
        Node left;
        Node right;
        // 高度
        int height;

        @Override
        public String toString() {
            return val + "";
        }
    }

}