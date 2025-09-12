package lee.erfen;

import org.springframework.util.StringUtils;

/**
 * @Author Yves
 * @Data 2023/4/4 下午4:39
 *
 * 异或操作符  ^
 */
public class OperateYiHuo extends ArrBase{

    public static void main(String[] args) {
        //1.交换位置
        System.out.println(StringUtils.arrayToCommaDelimitedString(integerArr));
        System.out.println(StringUtils.arrayToCommaDelimitedString(swap(integerArr, 0, 1)));

        //2.一个数组中，只有一个数出现奇数次 求这个数
        int number =0;
        for (int i = 0; i < integerArr.length; i++) {
            number ^= integerArr[i];
        }
        System.out.println(number);

        //3.一个数组中，只有两个数出现奇数次 求这两个数
        int evo =0;
        for (int i = 0; i < twoOddArr.length; i++) {
            // 先计算出 a ^ b 的值  因为a!=b, 所以a和b的二进制上必然有一位是（0，1）或者（1，0），
            // 那么根据这一特殊位置 ，将数组可以区分为两类，一类是在改位上是1，一类是0
            // 而a，b肯定不会在同一类
            evo ^= twoOddArr[i];
        }
        int evo1 = 0;
        int onlyOne = evo & (~evo+1);   //***** a & (~a + 1)  计算出二进制最右侧为1的数 eg.  ...000001000 ******
        for (int i = 0; i < twoOddArr.length; i++) {
            // 得出在某一位上是1的异或值（非a则b）
            if ((twoOddArr[i] & onlyOne) != 0) {
                evo1 ^= twoOddArr[i];
            }
        }
        System.out.println(evo1 + "," + (evo ^ evo1));

    }

    private static Integer[] swap(Integer[] arr, int x,int y) {
        arr[x] = arr[x] ^ arr[y];
        arr[y] = arr[x] ^ arr[y];
        arr[x] = arr[x] ^ arr[y];
        return arr;
    }
}
