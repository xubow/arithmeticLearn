package tree;

import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenyves
 * @description: ( 二叉树的层序遍历 II
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description/)
 *
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * @date 2025/8/3 11:51
 * @since JDK 1.8
 */
public class LevelOrderBottom {


    /**
     * 广度优先遍历后实现层序遍历  最后将list元素反转
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            TreeNode cur = queue.peek();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                queue.poll();
            }
            res.add(list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = res.size() -1; i >= 0; i--) {
            ans.add(res.get(i));
        }
        return ans;

    }
}