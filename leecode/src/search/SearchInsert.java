package search;

/**
 * @author chenyves
 * @description: (搜索插入位置)
 * https://leetcode.cn/problems/search-insert-position/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 思路： 确定二分模型 [0,0,0,1,1,1,1]     right = mid
 *      将小于目标值的位置记为0，大于等于目标值的位置记为1， 求第一个1的位置
 *
 *
 * @date 2025/8/24 17:48
 * @since JDK 1.8
 */
public class SearchInsert {

    public int search(int[] nums, int target) {
        // 正常会设置right= nums.length-1 ，但是本题会出现target大于所有元素值，返回的下标是n
        // 在二分中的头尾指针必须得包含所有查找的位置，所以此处right = nums.length
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

}