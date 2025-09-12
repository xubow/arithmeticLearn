package recursion;

/**
 * @author chenyves
 * @description: (递归实现组合型枚举)
 * 题目描述
 * 从这 n个整数中随机选取 m个，每种方案里的数从小到大排列，按字典序输出所有可能的选择方案。
 *
 * 输入
 * 输入两个整数 n,m。（1≤m≤n≤10）
 *
 * 输出
 * 每行一组方案，每组方案中两个数之间用空格分隔。注意每行最后一个数后没有空格。
 *
 * e.g.
 * 输入 3 2
 * 输出
 * 1 2
 * 1 3
 * 2 3
 * @date 2025/6/30 22:18
 * @since JDK 1.8
 */
public class Class4_compositeEnumeration {
    // 设定最大m=10
    private static int[] arr = new int[10];

    public static void main(String[] args) {
        f(0, 1, 3, 2);
        System.out.println("-------------");
        f(0, 1, 5, 3);
    }

    /**
     * 定义函数 f(i) i位置上的所有枚举打印
     * @param i 数组下标
     * @param j 数组arr 在i位置上最小的数
     * @param n 数组arr 在i位置上最大的数
     * @param m 数组长度
     */
    public static void f(int i, int j, int n, int m) {
        // 边界条件 当数组下标i（从0开始）等于最大长度数的时候 return
        if (i == m) {
            // 打印当前i位置上的枚举
            print(i);
            return;
        }
        // 枚举当前位置可以填的数字
        // 因为是指定长度的输出 所以当前位置上的数k不能每次都增加到最大值n，所以k值有上限
        // 可以设想数组arr， 当在i位置上时，后面还有几个空位。  m-1-i
        // 那么i位置上的数k，就不能大于 n-(m-1-i)
        for (int k = j; k <= n && k<= n-(m-1-i); k++) {
            arr[i] = k;
            // 给数组arr赋值下一位上的数  直到i==m
            f(i+1, k+1, n, m);
        }

    }

    /**
     * 打印数组
     * @param n
     */
    private static void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ") ;
        }
        System.out.println();
    }

}