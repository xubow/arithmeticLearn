package recursion;

/**
 * @author chenyves
 * @description: (路飞吃桃  https://oj.haizeix.com/problem/184)
 * 题目描述
 * 路飞买了一堆桃子不知道个数，第一天吃了一半的桃子，还不过瘾，又多吃了一个。以后他每天吃剩下的桃子的一半还多一个
 * ，到 n天只剩下一个桃子了。路飞想知道一开始买了多少桃子。
 *
 * 输入
 * 输入一个整数 n(2≤n≤30)
 *
 * 输出
 * 输出买的桃子的数量。
 * @date 2025/6/30 15:42
 * @since JDK 1.8
 */
public class Class1_LufeiPeach {

    public static void main(String[] args) {
        System.out.println(f(2));
        System.out.println(f(3));
    }

    /**
     * 定义函数f(n) 能吃n天的桃子数量
     *  f(1) = 1  f(1) = f(2)/2 - 1
     *  f(2) = (f(1) + 1)*2
     *  ...
     *  f(n) = (f(n-1) + 1) * 2
     * @param n 第n天
     * @return 桃子数
     */
    public static int f(int n) {
        if (n == 1) return 1;
        return (f(n-1) + 1)*2;
    }
}