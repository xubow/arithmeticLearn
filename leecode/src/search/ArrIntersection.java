package search;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenyves
 * @description: (两个数组的交集)
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * 给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * @date 2025/8/24 20:00
 * @since JDK 1.8
 */
public class ArrIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        for (int num : nums1) {
            s1.add(num);
        }
        Set<Integer> s2 = new HashSet<>();
        for (int num : nums2) {
            if (s1.contains(num)) s2.add(num);
        }
        int[] ans = new int[s2.size()];
        int idx = 0;
        for (Integer ss : s2) {
            ans[idx ++] = ss;
        }
        return ans;
    }
}