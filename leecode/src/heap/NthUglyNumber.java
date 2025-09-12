package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author chenyves
 * @description: (丑数 II)
 * https://leetcode.cn/problems/ugly-number-ii/
 *
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是质因子只包含 2、3 和 5 的正整数。
 *
 * @date 2025/8/5 20:57
 * @since JDK 1.8
 */
public class NthUglyNumber {

    /**
     * method1. 借助set进行去重
     * method2. 当前值乘上当前数的最大质因子  if (num % 5 ==0 )  num % 3 ==0   num % 2 ==0
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        //                                      p2 p3 p5
        // 2 3 5     dp[2] = min{2,3,5} 2       1  1  1
        // 4 6 10    dp[3] = min{4,3,5} 3       2  2
        // 6 9 12    dp[4] = min{4,6,5} 4       3
        // 8 12 16   dp[5] = min{6,6,5} 5             2
        //           dp[6] = min{6,6,10} 6      4  3
        //           dp[7] min{8,9,10} 8        5
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        Set<Long> set = new HashSet<>();
        int ans = -1;
        for(int i = 0; i< n;  i++) {
            ans = queue.poll().intValue();
            if (set.add(ans*2L)) {
                queue.add(ans*2L);
            }
            if (set.add(ans*3L)) {
                queue.add(ans*3L);
            }
            if (set.add(ans*5L)) {
                queue.add(ans*5L);
            }
        }
        return ans;
    }
}