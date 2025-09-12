package search;

import sort.util.ArrUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyves
 * @description: (两数之和)
 * https://leetcode.cn/problems/two-sum/
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案
 * @date 2025/8/24 13:22
 * @since JDK 1.8
 */
public class TwoNumSum {

    public static void main(String[] args) {
        int[] arr = new int[]{95, 42, 67, 21, 83, 52, 80, 2, 12, 38, 62};
        ArrUtil.printArr(arr);
        int[] ans = twoSum_sorTwoPoint(arr, 14);
        ArrUtil.printArr(ans);
    }

    /**
     * 遍历数组 将每个数据放入hash表中
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_hashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 数值和对应的下标
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) return new int[]{map.get(val), i};
            map.put(nums[i], i);
        }
        return null;
    }


    /**
     * 1. 排序数组
     * 2. 首尾指针位置求和 如果值大于target 尾指针-1； 如果值小于target，头指针+1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_sorTwoPoint(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs, Comparator.comparingInt(o -> o.fst));
        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            if (pairs[head].fst + pairs[tail].fst == target) return new int[]{pairs[head].snd, pairs[tail].snd};
            if (pairs[head].fst + pairs[tail].fst < target) head++;
            else tail--;
        }
        return null;
    }

   static class Pair {
        Integer fst;
        Integer snd;
        Pair(Integer fst, Integer snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }
}