package search;

/**
 * @author chenyves
 * @description: (寻找两个正序数组的中位数)
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 使用二分查找思路解题
 * 问题转换： 两个有序数组中找到第k大的数
 * 分别从nums1 nums2中取k/2的数  分别为 n1,n2
 * [1,2,3,4,5,6 .......]   [2,3,4,5,6,7 .......]
 *            n1                      n2
 *  如果n1<n2  那么n1最多能排在k-1的位置（n1只比n2小）可推出 nums1数组中 0~n1范围上的k/2个数字都是k之前的数
 *  问题转换： nums1(n1~末尾)  num2 两个数组中找到(k - k/2)大的数
 *  .....
 *  直到k=1 nums1(x~y)  nums2(p~q)  取min(x, p) 就是初始两个数组上第k个位置的数
 *
 * @date 2025/8/25 22:12
 * @since JDK 1.8
 */
public class FindMedianSortedArr {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, 4};
        int[] nums2 = new int[]{1};
        new FindMedianSortedArr().findMedianSortedArrays(nums1, nums2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length , l2 = nums2.length;
        if ((l1 + l2) % 2 == 0)
            return (findK(nums1, nums2, 0, 0,(l1 + l2)/2) + findK(nums1, nums2, 0, 0,(l1 + l2 )/2 + 1))/2.0;
        return findK(nums1, nums2, 0, 0,(l1 + l2+1)/2);
    }

    public double findK(int[] nums1, int[] nums2, int p, int q, int k) {
        // 如果其中一个数组都取完了  直接选择另外一个数组的第k个元素即可
        if (p  >= nums1.length) {
            return nums2[q + k - 1];
        }
        if (q  >= nums2.length) {
            return nums1[p + k - 1];
        }
        // 如果k==1 直接取两个数组的头一个元素的最小值
        if (k == 1) {
            return Math.min(nums1[p], nums2[q]);
        }

        // 如果nums1元素不够k/2  就只取剩下的所有， 如果够 就正常取k/2个
        int cnt1 = Math.min(k/2, nums1.length - p);
        // 如果nums2的元素个数不够 k-cnt1 个  就只取剩下的所有，此时cnt1就得重新多取  取够k个
        int cnt2 = Math.min(k - cnt1, nums2.length-q);
        // 重新计算一下cnt1的个数 来回计算一下  就能包含 nums1数量小于nums2数量 以及nums2数量小于nums1数量 两种情况
        cnt1 = k - cnt2;
        if (nums1[p + cnt1 -1] <= nums2[q + cnt2 - 1]) {
            // 通过下标的递增，表示数组的缩减
            p = p + cnt1;
            // 因为某个数组个数不够k/2个 所以每次缩减的个数不一定是k/2
            return findK(nums1, nums2, p, q, k-cnt1);
        }
        q = q + cnt2;
        return findK(nums1, nums2, p, q, k-cnt2);
    }
}