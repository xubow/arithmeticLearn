package tree;

import tree.model.TreeNode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author chenyves
 * @description: (二叉树的层序遍历 https://leetcode.cn/problems/binary-tree-level-order-traversal/description/)
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * @date 2025/8/1 16:29
 * @since JDK 1.8
 */
public class LevelOrder {


    private final Queue<TreeNode> queue = new LinkedList<>();

    /**
     * 利用bfs 广度优先遍历的队列思想
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            // 因为要记录同一层的所有值 为了避免 右节点 和 左节点的子节点 同时都在队列中的情况（右节点还未弹出）
            // 获取当前队列中的所有个数，代表当前层有几个节点
            int cnt = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode cur = queue.peek();
                tmp.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                queue.poll();
            }
            ans.add(tmp);
        }
        return ans;

    }


    /**
     * 利用dfs也能实现 记录同一层的节点
     * @param root
     * @return
     */
    public List<List<Integer>> level_order_dfs(TreeNode root) {
        if (root == null) return null;
        // 定义map value=层数
        Map<TreeNode, Integer> ans = new HashMap<>();
        // 从第一层开始
        dfs(root, ans, 0);
        return map2List(ans);
    }

    /**
     *
     * @param root
     * @param ans
     * @param k 第几层
     */
    public void dfs(TreeNode root, Map<TreeNode, Integer> ans, int k) {
        if (root == null) {
            return;
        }
        ans.put(root, k);
        dfs(root.left, ans, k+1);
        dfs(root.right, ans, k+1);
    }

    public List<List<Integer>> map2List(Map<TreeNode, Integer> ans) {
        if (ans.isEmpty()) {
            return new ArrayList<>();
        }



        return null;
    }
}