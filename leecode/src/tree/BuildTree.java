package tree;

import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyves
 * @description: (从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * @date 2025/8/1 11:02
 * @since JDK 1.8
 */
public class BuildTree {

    public static void main(String[] args) {
        BuildTree bt = new BuildTree();
        int[] preorder= new int[]{3,9,20,15,7};
        int[] inorder= new int[]{9,3,15,20,7};
        bt.buildTree(preorder, inorder);
    }

    /**
     * 前序遍历  【root】【左子树】 【右子树】
     * 中序遍历   【左子树】 【root】 【右子树】
     *
     * 可以发现 给定某个节点的前序和中序 就能得出当前节点的左右子树
     * 所以有递归性质
     *
     * 函数定义： 给定前序和中序 返回root节点的树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 临界条件 如果前序和中序为空，代表是空节点
        if (preorder.length == 0) {
            return null;
        }
        // 当前头节点就是前序遍历的第一个值
        TreeNode root = new TreeNode(preorder[0]);
        // 在中序遍历中找到root的下标 可以根据中序遍历找到root节点的左右子树
        // 左子树就是0～root_idx-1
        // 右子树 root_idx + 1, inorder.length
        int root_idx = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[root_idx] != preorder[0]) {
                root_idx ++;
            } else {
                break;
            }
        }

        int n = inorder.length;
        // 左子树的前序
        ArrayList<Integer> preArr = new ArrayList<>();
        // 左子树的中序
        List<Integer> inArr = new ArrayList<>();
        for (int i = 1; i<=root_idx; i++) {
            preArr.add(preorder[i]);
        }
        for (int i = 0; i<root_idx;i++) {
            inArr.add(inorder[i]);
        }
        TreeNode left = buildTree(list2Arr(preArr), list2Arr(inArr));

        // 右子树的前序
        preArr.clear();
        // 右子树的中序
        inArr.clear();
        for (int i = root_idx+1; i<preorder.length; i++) {
            preArr.add(preorder[i]);
        }
        for (int i = root_idx +1; i<n;i++) {
            inArr.add(inorder[i]);
        }
        TreeNode right =  buildTree(list2Arr(preArr), list2Arr(inArr));
        root.left = left;
        root.right = right;
        return root;

    }

    private int[] list2Arr(List<Integer> list) {
        int[] arr = new int[list.size()];
        int index = 0;
        for (Integer num : list) {
            arr[index ++] = num;
        }
        return arr;
    }
}