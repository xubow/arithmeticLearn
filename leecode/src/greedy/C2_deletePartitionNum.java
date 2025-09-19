package greedy;

import sort.util.ArrUtil;

/**
 * @author chenyves
 * @description: (删数)
 * https://oj.haizeix.com/problem/504
 *
 *  输入一个高精度的正整数 n（长度不大于 240位），去掉其中任意 s个数字后剩下的数字按原左右次序将组成一个新的正整数，
 *  现求一种方案，使得新的正整数数值最小。
 *  e.g. 输入 179566 4
 *  输出 15 （删除7966）
 *
 *  思路： 每次删除逆序第一位。 举例：12354 1~5是正序递增，5~4开始逆序，所以删除5
 *  需要证明：
 *   1. 假设只删除一位数，删除逆序位第一个数，使得数变最小  (局部)
 *   2. 两个相同位数的数AB，当A<B,并且只有其中一位不同，同时删除相同数量的数字，依旧保证A<B  （递推到全局）
 * @date 2025/9/19 13:45
 * @since JDK 1.8
 */
public class C2_deletePartitionNum {
    public static void main(String[] args) {
        String str = "179566";
        char[] ca = str.toCharArray();
        int[] ia = new int[ca.length];
        for (int i = 0; i < ca.length; i++) {
            ia[i] = Integer.parseInt(String.valueOf(ca[i]));
        }
        System.out.println(deletePart(ia, 4));
    }

    static Integer deletePart(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int j = 0;
            // 定位到第一个逆序位置
            while ((j+1) < n && nums[j] < nums[j+1]) j++;
            // 删除j位置的数，即将后面的数往前都移动一位
            while ((j+1) < n) {
                nums[j] = nums[j+1];
                // 数组新长度-1
                n--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        // 会自动去除头部的0
        return Integer.parseInt(sb.toString());
    }
}