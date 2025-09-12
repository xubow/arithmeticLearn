package tree.redBlackTree;

import sort.util.ArrUtil;

/**
 * @author chenyves
 * @description: (红黑树)
 *
 * 平衡条件
 * 1. 节点非红即黑
 * 2. 头节点是黑色
 * 3. 叶子结点（NIL）是黑色
 * 4. 红色节点的双子节点是黑色
 * 5. 从根节点到每个叶子节点的路径上，黑色节点数量相同
 *
 * 最短路径： 全黑节点 （n个黑）
 * 最长路径： 红黑相间 （n个黑 n个红）
 * 通过维护最短路径和最长路径是两倍关系 保持平衡
 *
 *
 *
 * @date 2025/9/2 15:01
 * @since JDK 1.8
 */
public class RedBlackTree {
    
    static final int RED = 0;
    static final int BLACK = 1;
    static final int DB_BLACK = 2;

    public static void main(String[] args) {
        int[] arr = new int[]{96, 57, 98, 40, 50};
        ArrUtil.printArr(arr);
        RedBlackTree instance = new RedBlackTree();
        Node head = NIL;
        for (int num : arr) {
            head = instance.insert(head, num);
        }
        printTree(head);

        System.out.println("----------after erase-----------");
        head = instance.erase(head, 50);
        printTree(head);
    }

    /**
     * 每次插入新节点后 root节点置为黑
     * @param head
     * @param key
     * @return
     */
    Node insert(Node head, int key) {
        Node root = __insert(head, key);
        // 最后根节点一定是黑色
        root.color = BLACK;
        return root;
    }

    Node erase(Node root, int key) {
        root = __erase(root, key);
        // 双重黑会一直往上传递，所以最后将头节点一律改成黑色
        root.color = BLACK;
        return root;
    }


    Node __insert(Node head, int key) {
        // node为空 直接返回新节点
        if (head == NIL) return getNewNode(key);
        // 值相同 不做重复插入
        if (key == head.val) return head;
        if (key < head.val) head.left = __insert(head.left, key);
        else head.right = __insert(head.right, key);

        // 解决插入失衡
        return insertMaintain(head);
    }

    /**
     * 处理失衡
     * 判断插入失衡时，是从***祖父节点***进行判断
     * @param root
     * @return
     */
    Node insertMaintain(Node root) {
        // 如果当前节点没有红色子节点 则不会有失衡
        // if (!hasRedChild(root)) return root; // 因为下面分别判断了左右子树是否为红色 ，所以此处的if判断可以省略
        // root左节点是红色
        if (root.left.color == RED) {
            if (!hasRedChild(root.left)) return root;
            // 左子树出现双红 并且叔父节点是红色
            if (root.right.color == RED) {
                // 变成红黑黑即可
                redUp(root);
                return root;
            }
            // LR类型
            if (root.left.right.color == RED) {
                // 对root.left 小左旋
                root.left = leftRotate(root.left);
            }
            // LL类型  对root大右旋
            root = rightRotate(root);
            redUp(root);
        }
        // root右节点是红色
        if (root.right.color == RED) {
            if (!hasRedChild(root.right)) return root;
            // 右子树出现双红 并且叔父节点是红色
            if (root.left.color == RED) {
                // 变成红黑黑即可
                redUp(root);
                return root;
            }
            // RL类型
            if (root.right.left.color == RED) {
                // 对root.right 小右旋
                root.right = rightRotate(root.right);
            }
            // root大左旋
            root = leftRotate(root);
            redUp(root);
        }
        // 最后根节点一定是黑色 在insert方法最外层统一处理
//        root.color = BLACK;
        return root;
    }

    Node __erase(Node root, int key) {
        if (root == NIL) return root;
        if (key < root.val) {
            root.left = __erase(root.left, key);
        } else if(key > root.val) {
            root.right = __erase(root.right, key);
        } else {
            if (root.left == NIL || root.right == NIL) {
                // 获取root的子节点 此处同时包括度为0或者1的情况
                Node tmp = root.left == NIL ? root.right : root.left;
                // 红色度为0 直接删除 颜色会变为黑的空节点  0（红）+1（黑）=1（黑）
                // 黑色度为1 红色子节点变为黑色，上升  0（红）+1（黑）=1（黑）
                // 黑色度为0 会升级成双黑，子节点就是黑色NIL 1（黑） + 1（黑） = 2（双黑）
                tmp.color += root.color;
                return tmp;
            } else {
                // 没有空节点 即度为2的情况
                // 找到前驱节点
                Node processor = findProcessor(root);
                // 根节点值变为前驱节点值
                root.val = processor.val;
                // 在左子树中删除前驱节点
                root.left = __erase(root.left, processor.val);
            }
        }
        // 处理失衡 双黑节点
        return erase_maintain(root);
    }

    /**
     * 处理双黑节点
     * @param root
     * @return
     */
    Node erase_maintain(Node root) {
        // 没有双黑子节点 则不需要处理
        if (root.left.color != DB_BLACK && root.right.color != DB_BLACK) return root;
        // 左子节点为双黑
        if (root.left.color == DB_BLACK) {
            // 兄弟节点为黑
            if (root.right.color == BLACK ) {
                // 没有红色子节点 直接修改颜色即可
                if (!hasRedChild(root.right)) {
                    // 双黑节点颜色变成正常黑
                    root.left.color -= 1;
                    // 双黑传递到根节点
                    root.color += 1;
                    root.right.color -= 1;
                    return root;
                } else {
                    if (root.right.right.color == RED) {
                        // 兄弟节点 同侧子节点 为红色 root节点进行左旋
                        // 新根颜色为原根的颜色 新根是原根的右子节点
                        root.right.color = root.color;
                        root = leftRotate(root);
                        // 旋转之后，新根的左右子节点颜色变为黑色
                        root.left.color = root.right.color = BLACK;
                    } else if (root.right.left.color == RED) {
                        // 兄弟节点 非同侧子节点 为红色 先对兄弟节点进行右旋  再对root进行左旋
                        root.right = rightRotate(root.right);
                        // 兄弟节点右旋之后 需要将新根（原兄弟节点的左子节点）变为黑色，将原根变为红色
                        // 但是下一步还是要对root进行左旋之后，对这两个节点会重新变色，所以此处变色可省略
                        root.right.color = root.color;
                        root = leftRotate(root);
                        // 旋转之后，新根的左右子节点颜色变为黑色
                        root.left.color = root.right.color = BLACK;
                    }
                }
            } else {
                // 兄弟节点为红色 对根节点进行左旋
                root = leftRotate(root);
                // 新根变为黑
                root.color = BLACK;
                // 原根变为红
                root.left.color = RED;
                // 对新根的左子节点进行重复的删除调整步骤
                root.left = erase_maintain(root.left);
            }
        } else {
            // 右子节点为双黑
            // 兄弟节点为黑
            if (root.left.color == BLACK ) {
                // 没有红色子节点 直接修改颜色即可
                if (!hasRedChild(root.left)) {
                    // 双黑节点颜色变成正常黑
                    root.right.color -= 1;
                    // 双黑传递到根节点
                    root.color += 1;
                    root.left.color -= 1;
                    return root;
                } else {
                    if (root.left.left.color == RED) {
                        // 兄弟节点 同侧子节点 为红色 root节点进行左旋
                        // 新根颜色为原根的颜色 新根是原根的右子节点
                        root.left.color = root.color;
                        root = rightRotate(root);
                        // 旋转之后，新根的左右子节点颜色变为黑色
                        root.left.color = root.right.color = BLACK;
                    } else if (root.left.right.color == RED) {
                        // 兄弟节点 非同侧子节点 为红色 先对兄弟节点进行右旋  再对root进行左旋
                        root.left = leftRotate(root.left);
                        // 兄弟节点右旋之后 需要将新根（原兄弟节点的右子节点）变为黑色，将原根变为红色
                        // 但是下一步还是要对root进行左旋之后，对这两个节点会重新变色，所以此处变色可省略
                        root.left.color = root.color;
                        root = rightRotate(root);
                        // 旋转之后，新根的左右子节点颜色变为黑色
                        root.left.color = root.right.color = BLACK;
                    }
                }
            } else {
                // 兄弟节点为红色 对根节点进行右旋
                root = rightRotate(root);
                // 新根变为黑
                root.color = BLACK;
                // 原根变为红
                root.right.color = RED;
                // 对新根的左子节点进行重复的删除调整步骤
                root.right = erase_maintain(root.right);
            }
        }
        return root;
    }



    /**
     * 获取前驱节点
     * @param root
     * @return
     */
    Node findProcessor(Node root) {
        Node tmp = root.left;
        while (tmp.right != NIL) {
            tmp = tmp.right;
        }
        return tmp;
    }

    void redUp(Node root) {
        root.color = RED;
        root.left.color = BLACK;
        root.right.color = BLACK;
    }

    /**
     * 左旋
     * @param head
     * @return
     */
    Node leftRotate(Node head) {
        Node newHead = head.right;
        head.right = newHead.left;
        newHead.left = head;
        return newHead;
    }

    /**
     * 右旋
     * @param head
     * @return
     */
    Node rightRotate(Node head) {
        Node newHead = head.left;
        head.left = newHead.right;
        newHead.right = head;
        return newHead;
    }

    /**
     * 判断是否有红色子节点
     * @param root
     * @return
     */
    boolean hasRedChild(Node root) {
        return root.left.color == RED || root.right.color == RED;
    }

    Node getNewNode(int key) {
        Node node = new Node();
        node.left = node.right = NIL;
        node.val = key;
        // 新节点为红色
        node.color = RED;
        return node;
    }

    static void printTree(Node head) {
        if (head == NIL) return;
        System.out.println("[" + head.val + "|" + head.color + "] (" + head.left.val + "," + head.right.val + ")");
        printTree(head.left);
        printTree(head.right);
    }

    // 定义空节点
    static Node NIL;
    static {
        NIL = new Node();
        NIL.left = NIL.right = NIL;
        NIL.val = -1;
        NIL.color = BLACK;
    }


    static class Node {
        int val;
        Node left;
        Node right;
        int color;

        @Override
        public String toString() {
            return this.val + "";
        }
    }

   
}