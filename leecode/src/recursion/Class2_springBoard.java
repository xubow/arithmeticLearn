package recursion;

import java.util.Arrays;

/**
 * @author chenyves
 * @description: (弹簧板)
 *
 * 题目描述
 * 有一个小球掉落在一串连续的弹簧板上，小球落到某一个弹簧板后，会被弹到某一个地点，直到小球被弹到弹簧板以外的地方
 * 假设有n个连续的弹簧板，每个弹簧板占一个单位距离，a[i]代表代表第 i个弹簧板会把小球向前弹 a[i]个距离。
 * 比如位置 1的弹簧能让小球前进 2个距离到达位置 3。如果小球落到某个弹簧板后，经过一系列弹跳会被弹出弹簧板，
 * 那么小球就能从这个弹簧板弹出来
 * 现在小球掉到了1号弹簧板上面，那么这个小球会被弹起多少次，才会弹出弹簧板。 1号弹簧板也算一次
 * @date 2025/6/30 21:54
 * @since JDK 1.8
 */
public class Class2_springBoard {

    public static void main(String[] args) {
        System.out.println(f(0, 5, new int[]{2, 2, 3, 1, 2}));
        System.out.println(f(0, 5, new int[]{1, 2, 3, 1, 2}));
    }

    /**
     * 定义函数 从i位置上被弹出弹簧板的次数
     * @param i
     * @param n
     * @return
     */
    public static int f(int i, int n, int[] arr) {
        if (i >= n) return 0;
        // f(i) = f(i + arr[i]) + 1
        // 从i位置上被弹出的次数 = 下一个位置上被弹出的次数 + 1
        return f(i + arr[i], n, arr) + 1;
    }
}