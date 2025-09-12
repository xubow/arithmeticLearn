package search;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenyves
 * @description: (存在重复元素)
 * https://leetcode.cn/problems/contains-duplicate/description/
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * 利用hashset
 *
 * @date 2025/8/24 19:57
 * @since JDK 1.8
 */
public class ContainDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}