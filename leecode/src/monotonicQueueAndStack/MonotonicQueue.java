package monotonicQueueAndStack;

import sort.util.ArrUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenyves
 * @description: (单调队列)
 *
 * 用于求区间最值
 *
 * @date 2025/9/11 14:03
 * @since JDK 1.8
 */
public class MonotonicQueue {

    public static void main(String[] args) {
        int[] arr = ArrUtil.randomArr(10);
        ArrUtil.printArr(arr);
        System.out.println("-------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        rmq(arr, 3);
    }

    /**
     *
     * @param arr
     * @param k  区间的长度
     */
    static void rmq(int[] arr, int k) {
        // 双端队列 存放下标
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while(!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - deque.peekFirst() == k) deque.pollFirst();
            System.out.printf("范围[%d-%d], 最小值:%d%n", Math.max(i-k+1, 0), i, arr[deque.peekFirst()]);
        }
    }

}