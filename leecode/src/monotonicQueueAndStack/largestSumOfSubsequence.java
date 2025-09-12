package monotonicQueueAndStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenyves
 * @description: (最大子序和)
 * https://oj.haizeix.com/problem/270
 *
 * 输入一个长度为 n的整数序列，从中找出一段不超过 M的连续子序列，使得整个序列的和最大。
 *
 * 思路：
 *  1. 求前缀和 S1,S2...Sn
 *  2. S(i+m) - S(i) 就是原数组[i+1,..., i+m]的子序列和
 *  3。假设固定i+m的位置，想要子序列和最大，那么S(i)就要最小，所以需要维护区间最小值
 *
 * 例如 1，−3,5,1，−2,3
 * 当 m=4时，S=5+1−2+3=7
 * 当 m=2或 m=3时，S=5+1=6
 *
 * @date 2025/9/12 14:10
 * @since JDK 1.8
 */
public class largestSumOfSubsequence {

    public static void main(String[] args) {
        int[] arr = new int[]{1, -3, 5, 1, -2, 3};
        System.out.println(sum(arr, 2));
    }

   static int sum(int[] arr, int m) {
        // 前缀和
        int[] s = new int[arr.length];
        s[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            s[i] = s[i-1] + arr[i];
        }

        int ans = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < s.length; i++) {
            // 维护区间最小队列
            while(!deque.isEmpty() && s[deque.peekLast()]>s[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            ans = Math.max(ans, s[i] - s[deque.peekFirst()]);
            if (i - deque.peekFirst() == m) {
                deque.pollFirst();
            }
        }
        return ans;
    }
}