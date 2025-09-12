package tree;

import tree.model.TreeNode;

import java.util.*;

/**
 * @author chenyves
 * @description: (二叉树的锯齿形层序遍历
 *https : / / leetcode.cn / problems / binary - tree - zigzag - level - order - traversal / description /)
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @date 2025/8/3 12:06
 * @since JDK 1.8
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // flag = 0;
        queue.add(root);
        // 定义一个flag 0-正序 1-反序 因为root节点第一个放入，第二层就是反序
        int flag = 1;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
//            List<Integer> list = new ArrayList<>();
            LinkedList<Integer> list  = new LinkedList<>();
            // 采用LinkedList addFirst() addLst() 实现反序
            for (int i = 0; i < cnt; i++) {
                TreeNode cur = queue.peek();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                if (flag == 1) {
                    list.addFirst(cur.val);
                } else {
                    list.addLast(cur.val);
                }
//                list.add(cur.val);
                queue.poll();
            }
            // 采用linkedList后 就不用反序操作了
//            if (flag == 1) {
//                Collections.reverse(list);
//            }
            flag = flag == 1 ? 0 : 1;
            ans.add(list);
        }
        return ans;
    }
}