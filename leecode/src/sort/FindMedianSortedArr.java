package sort;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyves
 * @description: (寻找两个正序数组的中位数)
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @date 2025/8/17 17:37
 * @since JDK 1.8
 */
public class FindMedianSortedArr {


    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,1};
        int[] arr2 = new int[]{3, 4};
//        System.out.println(new FindMedianSortedArr().findMedianSortedArrays(arr1, arr2));
//        System.out.println((2+3)/2.0);
        System.out.println(containsNearbyDuplicate(arr1, 3));

    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i <= map.get(nums[i]) + k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) >>  1;
        // p nums1的指针下标  q为nums2指针下标
        int p = 0, q = 0;
        int[] tmp = new int[m+n];
        int idx = 0;
        while (p < m || q < n) {
            if (q >= n || (p < m && nums1[p] < nums2[q])) {
                tmp[idx++] = nums1[p++];
            } else {
                tmp[idx++] = nums2[q++];
            }
        }

        return (m+n)%2 == 0? (tmp[mid] + tmp[mid-1])/2.0 : tmp[mid];
    }
}