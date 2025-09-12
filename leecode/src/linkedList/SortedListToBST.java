package linkedList;

import linkedList.model.ListNode;
import linkedList.model.TreeNode;

/**
 * @author chenyves
 * @description: (有序链表转换二叉搜索树 https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/?envType=problem-list-v2&envId=linked-list)
 *
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为 平衡 二叉搜索树。
 *
 * @date 2025/7/22 17:17
 * @since JDK 1.8
 */
public class SortedListToBST {


    public TreeNode sortedListToBST(ListNode head) {

        return createTree(head, null);
    }

    public TreeNode createTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = findMid(left, right);
        TreeNode root = new TreeNode(mid.getVal());
        root.left = createTree(left, mid);
        root.right = createTree(mid.next, right);
        return root;
    }

    public ListNode findMid(ListNode left, ListNode right) {
        ListNode slow = left, fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}