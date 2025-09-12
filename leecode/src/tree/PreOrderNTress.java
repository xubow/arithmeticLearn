package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyves
 * @description: (N 叉树的前序遍历 https://leetcode.cn/problems/n-ary-tree-preorder-traversal/description/)
 *
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * @date 2025/8/1 10:34
 * @since JDK 1.8
 */
public class PreOrderNTress {

    private List<Integer> ans = new ArrayList<>();

    /**
     * 递归 函数定义：当前root节点的前序遍历结果
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ans.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return ans;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}