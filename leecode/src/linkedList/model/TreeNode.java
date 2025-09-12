package linkedList.model;

/**
 * @author chenyves
 * @description: (请在此添加描述)
 * @date 2025/7/22 17:18
 * @since JDK 1.8
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
