package tree;

import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyves
 * @description: (深度优先遍历)
 * @date 2025/7/29 16:32
 * @since JDK 1.8
 */
public class DFS {

    private List<TreeNode> list = new ArrayList<>();

    /**
     * 利用系统栈实现的递归
     * @param root
     */
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}