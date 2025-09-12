package tree;

import java.util.PriorityQueue;

/**
 * @author chenyves
 * @description: (合并果子)
 * https://oj.haizeix.com/problem/287
 *  例如有 3种果子，数目依次为 1，2，9。可以先将 1、2堆合并，新堆数目为 3，耗费体力为 3
 * 。接着，将新堆与原先的第三堆合并，又得到新的堆，数目为 12，耗费体力为 12。
 * 所以多多总共耗费体力为 3+12=15。可以证明 15为最小的体力耗费值。
 * @date 2025/8/3 18:42
 * @since JDK 1.8
 */
public class ClassifyFruits {

    /**
     *
     * @param arr  arr[i] i水果的数量
     * @return
     */
    public Integer classify(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int j : arr) {
            queue.add(j);
        }
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            Integer first = queue.poll();
            Integer second = queue.poll();
            ans += (first + second);
            queue.add(ans);
        }
//        while (!queue.isEmpty() && queue.size() > 1) {
//            Integer first = queue.poll();
//            Integer second = queue.poll();
//            ans += (first + second);
//            queue.add(ans);
//        }
        return ans;
    }
}