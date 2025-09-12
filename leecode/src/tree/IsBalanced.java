package tree;

import tree.model.TreeNode;

/**
 * @author chenyves
 * @description: (平衡二叉树 https://leetcode.cn/problems/balanced-binary-tree/description/)
 *
 * 给定一个二叉树，判断它是否是 平衡二叉树 (平衡二叉树 是指该树所有节点的左右子树的高度相差不超过 1。)
 * @date 2025/7/29 16:43
 * @since JDK 1.8
 */
public class IsBalanced {


    public boolean isBalanced(TreeNode root) {
        return calHeight(root) != -1;
    }

    /**
     * 递归 计算左右子树的高度 root的高度就是Max(lenLeft, lenRight)+1
     * @param root
     * @return
     */
    public int calHeight(TreeNode root) {
        if (root == null) {
            // 叶子节点高度为0
            return 0;
        }
        // 递归左子树
        int leftLen = calHeight(root.left);
        if (leftLen == -1) {
            // -1 代表该节点的左右子树高度相差不为1 不是平衡树 直接返回即可
            return -1;
        }
        // 递归右子树
        int rightLen = calHeight(root.right);
        if (rightLen == -1) {
            return -1;
        }
        return Math.abs(leftLen- rightLen) <= 1 ?  Math.max(leftLen, rightLen) +1 : -1;
    }
}