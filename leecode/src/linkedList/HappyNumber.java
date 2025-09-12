package linkedList;

/**
 * @author chenyves
 * @description: (快乐数)
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * @date 2025/7/9 09:44
 * @since JDK 1.8
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(10));
    }

    /**
     * 因为n值下一个数的值是根据n来的  所以可以想象每次计算的过程相当于是一个链表
     * 把最终值1当成终点的null节点
     * 如果链表有闭环 代表不能变成1 不是快乐数
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        while (fast != 1) {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
            if (fast == slow & fast != 1) {
                return false;
            }
        }
        return true;
    }
    public static int getNext(int x) {
        //各个位数上平方和
        int res =0, d;
        while (x!=0) {
            d = x % 10;
            res += d*d;
            x /= 10;
        }
        return res;
    }
}