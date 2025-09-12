package monotonicQueueAndStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenyves
 * @description: (滑动窗口)
 * https://oj.haizeix.com/problem/271
 *
 * 给出一个长度为 N的数组，一个长为 K的滑动窗口从最左移动到最右，每次窗口移动,
 * 找出窗口在各个位置时的极大值和极小值。
 * @date 2025/9/12 09:27
 * @since JDK 1.8
 */
public class SlidingWindow {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5 ,3, 6, 7};
        printMax(arr, 3);
        System.out.println("------");
        printMin(arr, 3);
    }


   static void printMax(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() + k == i) {
                deque.pollFirst();
            }
            if (i >= k-1) {
                System.out.printf("区间【%d-%d】，最大值：%d \n", i-k+1, i, arr[deque.peekFirst()]);
            }
        }
    }

   static void printMin(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while(!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() + k == i) {
                deque.pollFirst();
            }
            if (i >= k-1) {
                System.out.printf("区间【%d-%d】，最小值：%d \n", i-k+1, i, arr[deque.peekFirst()]);
            }
        }
    }

}