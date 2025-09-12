package recursion;

/**
 * @author chenyves
 * @description: (用递归输出指数型枚举  https://oj.haizeix.com/problem/235)
 * e.g.
 *  输入N=3
 *  输出
 *      1
 *      1 2
 *      1 2 3
 *      1 3
 *      2
 *      2 3
 *      3
 * @date 2025/6/24 08:52
 * @since JDK 1.8
 */
public class Class3_IndexEnumeratePrint {

    private static int[] arr = new int[10];

    public static void main(String[] args) {
        f(0, 1, 3);
    }

    /**
     *
     * 1. 定义函数 在i位置上的所有指数枚举
     * @param i
     * @param min i位置上最小的数
     * @param n i位置上最大的数
     */
    public  static void f(int i, int min, int n) {
        // 2. 指定边界条件
        if (min > n) return;
        for (int j = min; j <= n; j++) {
            // i位置上的数 之后打印这个数组
            arr[i] = j;
            // 打印i位置上的枚举
            print(i);
            // 3. f(i)与f(i+1)的关系
            f(i+1, j+1, n);
        }
    }

    private static void print(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(arr[i]).append(" ");
        }
        if (n != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }

}