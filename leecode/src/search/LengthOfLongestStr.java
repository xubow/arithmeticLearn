package search;

import sort.util.ArrUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenyves
 * @description: (无重复字符的最长子串)
 * https://leetcode.cn/problems/wtcaE1/
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 *
 * @date 2025/8/24 20:06
 * @since JDK 1.8
 */
public class LengthOfLongestStr {


    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("qrsvbspk"));
        int[] arr = new int[256];
        String str = "asdfghkoyir9";
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]  += 1;
        }
        ArrUtil.printArr(arr);

    }
    /**
     * 滑动窗口+ hashset
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // dvdf
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int p = 0, q = 0, max = 0;
        while (q < arr.length) {
            if (!set.contains(arr[q])) {
                set.add(arr[q++]);
            } else {
                max = Math.max(max, set.size());
                // 一直删除一个字符 直到set中没有与arr[q]重复的
                while (set.contains(arr[q])) {
                    set.remove(arr[p++]);
                }
                set.add(arr[q]);
                q++;
            }
        }
        return Math.max(max, set.size());
    }
}