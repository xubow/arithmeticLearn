package recursion;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author chenyves
 * @description: (不规则街道  https://oj.haizeix.com/problem/239)
 * @date 2025/7/1 14:36
 * @since JDK 1.8
 */
public class Class6_irregularityStreet {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(f(13, 3)));
//        System.out.println((new BigDecimal("2").pow(2 * 3 - 2)));
//        System.out.println( new BigDecimal("2").pow(2).intValue());
    }

    /**
     * 定义函数 i编号的房子在n级城市中的坐标
     * @param i
     * @param n
     * @return
     */
    public static int[] f(int i,int n) {
        // 边界条件
        if (n == 1) {
            if (i == 1) {
                return new int[]{1, 2};
            } else if (i == 2) {
                return new int[]{2, 2};
            } else if (i == 3) {
                return new int[]{2, 1};
            } else if (i == 4) {
                return new int[]{1, 1};
            }
        }
        int[] last = f((1 << (2*n-2)) - i + 1, n - 1);
        return new int[]{last[1],  (1 << n)- (last[0] -1)};
    }


}