package linkedList;

import linkedList.model.ListNode;

import java.util.HashSet;
import java.util.Set;


/**
 * @author chenyves
 * @description: (链表组件 https://leetcode.cn/problems/linked-list-components/description/)
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
 * @date 2025/7/15 16:12
 * @since JDK 1.8
 */
public class NumComponentList {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }

        int res = 0;
        boolean inset = false;
        while (head != null) {
            if (sets.contains(head.getVal())) {
                // 如果连续节点都在数组中 算一个组件
                if (!inset) {
                    inset = true;
                    res ++;
                }
            } else {
                inset = false;
            }
            head = head.next;
        }
        return res;
    }
}