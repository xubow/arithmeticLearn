package tree;

import tree.model.TreeNode;

/**
 * @author chenyves
 * @description: (子结构判断)
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/description/
 *
 * 给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 * 注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 *
 * @date 2025/8/3 12:57
 * @since JDK 1.8
 */
public class IsSubstructure {

    boolean match(TreeNode A, TreeNode B) {
        if (A == null) return B== null;
        // 如果B为空 说明已经全部匹配完了
        if (B == null) return true;
        if (A.val != B.val) return false;
        return match(A.left, B.left) && match(A.right, B.right);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A== null || B == null) return false;
        // 如果当前AB节点相同 判断其子树结果是否相同
        if (A.val == B.val) {
            // 为了防止A树的子树中还有节点值和B相同，所以还是要继续往下递归判断
            // 不能直接return match(A,B)的结果
            return match(A, B)
                    || isSubStructure(A.left, B) || (isSubStructure(A.right, B));
        }
        // 如果当前AB节点不同 则分别判断A的左树和右树是否有B树子结构
        if (isSubStructure(A.left, B)) return true;
        if (isSubStructure(A.right, B)) return true;
        return false;
    }

    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        return (A != null && B != null)
                && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}