package sort;

/**
 * @author chenyves
 * @description: (合并两个有序数组)
 *
 * https://leetcode.cn/problems/merge-sorted-array/description/
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * @date 2025/8/17 17:01
 * @since JDK 1.8
 */
public class MergeTwoSortedArr {


    /**
     *  因为题目要求不能新建数组，但是nums1只有m长度有值，后n长度为空，所以可以从大到小进行反向merge
     *  定义两个尾部指针 比较大值 放入nums1尾部
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-1, q = n-1, idx = m + n -1;
        if (n == 1 && nums2[0] == 0) {
            return;
        }
        if (m == 1 && nums1[0] == 0) {
            nums1 = nums2;
            return;
        }
        while (p >= 0 && q >= 0) {
            if (nums1[p] > nums2[q]) {
                nums1[idx --] = nums1[p --];
            } else {
                nums1[idx --] = nums2[q --];
            }
        }
        while (q >= 0) {
            nums1[idx --] = nums2[q --];
        }
    }
}