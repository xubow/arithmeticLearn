package tree;

import tree.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenyves
 * @description: (广度优先遍历)
 * @date 2025/8/1 15:47
 * @since JDK 1.8
 */
public class BFS {

    private final Queue<TreeNode> queue = new LinkedList<>();

    /**
     * 利用队列实现 （FIFO）
     * 1.将节点压入队列
     * 2. 将队列头节点的左右子节点分别压入
     * 3. 弹出头节点
     * 4. 弹出的顺序就是广度优先遍历
     *
     * @param root
     */
    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.peek();
            System.out.println(curNode);
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) queue.offer(curNode.right);
            queue.poll();
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(42);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(45);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = new TreeNode(44);
        node2.left = new TreeNode(5);
        node2.right = new TreeNode(6);
        new BFS().bfs(node1);
    }
}