package DisjointSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenyves
 * @description: (最长连续序列)
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 示例 3：
 * 输入：nums = [1,0,1,2]
 * 输出：3
 *
 * 思路： 本质其实就是对数据进行分组，连续的归并一组，使用并查集，最后只要找到节点数最多的根节点即可
 *
 * @date 2025/9/10 14:02
 * @since JDK 1.8
 */
public class LongestConsecutive {

    class DisjointSet {
        int n;
        int[] fa;
        int[] size;

        public DisjointSet(int n) {
            this.n = n;
            this.fa = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            return fa[i] = (fa[i] == i ? i : find(fa[i]));
        }

        void merge(int a, int b) {
            int aa = find(a);
            int bb = find(b);
            fa[aa] = bb;
            size[bb] += size[aa];
        }
    }


    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        DisjointSet join = new DisjointSet(n);
        // nums的数字和下标的对应关系
        int idx = 0;
        // 记录nums[i] 和 并查集中idx下标的对应关系
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) continue;
            map.put(nums[i], idx ++);
            if (map.containsKey(nums[i] + 1)) {
                join.merge(map.get(nums[i]), map.get(nums[i] + 1));
            }
            if (map.containsKey(nums[i] - 1)) {
                join.merge(map.get(nums[i]), map.get(nums[i] -1));
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (join.fa[i] == i) {
                ans = Math.max(ans, join.size[i]);
            }
        }
        return ans;

    }
}