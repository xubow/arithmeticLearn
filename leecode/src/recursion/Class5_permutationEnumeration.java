package recursion;

import java.util.Arrays;

/**
 * @author chenyves
 * @description: (递归实现排列型枚举)
 * 题目描述
 *  从 1−n这 n个整数排成一排并打乱次序，按字典序输出所有可能的选择方案。
 *
 * 输入
 * 输入一个整数 n（1≤n≤8）
 *
 * 输出
 * 每行一组方案，每组方案中两个数之间用空格分隔。
 *
 * e.g.
 * 输入 3
 * 输出
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 * @date 2025/7/1 10:53
 * @since JDK 1.8
 */
public class Class5_permutationEnumeration {

    private static int[] arr = new int[10];
    // 用一个vis数组存储已经填写过的数 数组下标就是填写的数 vis[i] =0 代表未使用 1代表已经使用
    // 因为填写的数字是从1开始的 而数组下标是0开始，所以此处vis数组长度+1， 从vis[1]位置开始记录
    private static int[] vis = new int[11];

    static {
        Arrays.fill(vis, 0);
    }

    public static void main(String[] args) {
        f(0, 3);
    }

    /**
     * 定义函数 i位置上的所有枚举打印
     * @param i 数组下标
     * @param n 最大值
     */
    public static void f(int i, int n) {
        if (i == n) {
            //边界条件 arr数组已经全部填充 直接打印
            print(i);
            return;
        }
        for (int k = 1; k <= n ; k++) {
            if (vis[k] == 1) continue;
            //
            arr[i] = k;
            // 标记数字k已经被使用
            vis[k] = 1;
            // 填充arr数组 i+1位置上的数
            f(i+1, n);
            // 重置数字k  以便可以再次使用

            vis[k] = 0;

        }
    }

    /**
     * 打印arr数组
     * @param n
     */
    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }
}