package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenyves
 * @description: (最大整数)
 * https://oj.haizeix.com/problem/505
 *
 * 现在有 n个正整数，将他们连成一排，组成一个最大的整数。
 * 例如，现在有三个整数 13,312,343，连接成最大整数为 34331213
 *
 * 思路： 将所有数按照字典序排序，大的在前，最后一次拼接成最大数
 * 对于两个数A，B， 如果A >= B 则组成的最大数为AB  （两个数拼接，位数相同，比较最高位）
   递推：如果有三个数A，B，C ，如果A>C>B, 则组成ACB
 * @date 2025/9/19 10:52
 * @since JDK 1.8
 */
public class C1_maxNum {

    public static void main(String[] args) {
//        System.out.println("12".compareTo("123"));
        String[] nums = new String[]{"13","312","343"};
        System.out.println(maxNum(nums));
    }

    static String maxNum(String[] nums) {
        Arrays.sort(nums, (o1, o2) -> o2.compareTo(o1));
        StringBuilder ans= new StringBuilder();
        for (String num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }
}