package sort;

import sort.util.ArrUtil;

/**
 * @author chenyves
 * @description: (基数排序) O(n)
 *
 * 思路：
 *  规定： 每个相同位上的数字如果相同，则他们的相对位置不变
 *  e.g.                    [12, 32, 31, 21, 23, 42]
 *  step1: 按照个位数排序     [31, 21, 12, 32, 42, 23]   31 21个位数都是1，但是31在21前面，相对位置不变
 *  step2: 按照十位数排序     [12, 21, 23, 31, 32, 42]
 *
 *  上面例子中（两位数排序），基数k=10，个位数就是x%k,十位数为x/k (程序中int相除会向下取整 12/10=1, 22/10=2)
 *  那么对于三位数排序，如果基数k=10， 则需要按照个位、十位、百位进行三次排序
 *  那么对于四位数排序，如果基数k=10， 则需要按照个位、十位、百位、千位进行四次排序
 *  。。。。
 *  所以，基数k的选择可以优化。
 *  比如对于x=1234来说，如果k=100，那么x的个位数可以看成1234%100=34，十位数则是1234/100=12
 *  所以k的选择可以降低排序次数，增加效率，但是会增加内存消耗（因为需要k个数的一个数组来记录每个位数的前缀和），可以说是空间换时间
 *
 *  如何进行按照位数排序（以上面例子k=10）：
 *      step1: 对同一位上的数，先从个位进行统计,用一个int[]来记录，长度为基数k个, cnt[i]表示数字i的个数, 0<=i<k-1
 *             cnt:  [0, 2, 3, 1, 0, 0,0,0,0,0]  其中cnt[1]=2代表个位数1有两个 cnt[2] = 3代表个位数2有三个...
 *             cnt[1] + cnt[2] + cnt[3] = 2+3+1=6, 数组一共六个数需要排序
 *      step2: 根据cnt可以得出每个位置上的前缀和（c[i] = c[i] + c[i-1]），也就是cnt变成了[0, 2, 5, 6,  ... 6, 6,.. 6]
 *      step3: 新建立一个与原数组等长数组ans记录排序后的数据。有了每个数的前缀和，从数组末尾开始进行遍历，根据数的个位数的前缀和就能知道放在哪个位置
 *              e.g. 原数组尾部遍历, 42,个位数是42%k=2，2的前缀和为5，就把42放在arr[]第5个的位置上，arr[4]=42,然后将2的前缀和-1变为4；
 *                   等到遍历到32的时候，2的前缀和为4，就把32放在arr[]第四个的位置arr[3]=32，2的前缀和-1变为3;
 *                   ... 最后就能得到 ans = [31, 21, 12, 32, 42, 23]
 *      step4: 对ans进行按照十位数进行同样逻辑的排序 得出[12, 21, 23, 31, 32, 42]
 *
 * @date 2025/8/13 08:36
 * @since JDK 1.8
 */
public class RadixSort {

    private final int k = 10;


    public static void main(String[] args) {
        // 100以内的数字进行排序 因为k设定了10
        // 同理，如果要针对int32位的数字来进行排序， k的选值可以是2^16 = 65536， 这样就能将32位的int数字想成有16位组成一个个位数和十位数，进行两个排序即可
        int[] arr = ArrUtil.randomArr(10, 100);
        ArrUtil.printArr(arr);
        System.out.println("-------");
        new RadixSort().sort(arr, 0, arr.length-1);
        ArrUtil.printArr(arr);
        ArrUtil.check(arr);
    }

    public void sort(int[] arr, int left, int right) {
        int[] cnt = new int[k];
        // 遍历一边数组 将个位数的个数放入cnt中
        for (int i = left; i <= right ; i++) {
            cnt[arr[i] % k] += 1;
        }
        // 取前缀和
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i-1];
        }
        int[] ans = new int[right - left + 1];
        // 从后遍历原始数组
        for (int i = right; i >= left; i--) {
            // arr[i] % k 代表个数数字是多少
            // cnt[arr[i] % k] 取到对应前缀和，得出放在数组第几个位置
            ans[cnt[arr[i] % k] - 1] = arr[i];
            // 前缀和-1
            cnt[arr[i] % k] --;
        }

        //  ans拷贝回arr
        int idx = 0;
        for (int i = left; i <= right; i++) {
            arr[i] = ans[idx++];
        }

        // arr的十位数进行相同操作  注意 %改为/
        int[] cnt_2 = new int[k];
        // 遍历一边数组 将十位数的个数放入cnt中
        for (int i = left; i <= right ; i++) {
            cnt_2[arr[i] / k] += 1;
        }
        // 取前缀和
        for (int i = 1; i < cnt_2.length; i++) {
            cnt_2[i] += cnt_2[i-1];
        }
        // 从后遍历原始数组
        for (int i = right; i >= left; i--) {
            // arr[i] / k 代表十位数数字是多少
            // cnt[arr[i] / k] 取到对应前缀和，得出放在数组第几个位置
            ans[cnt_2[arr[i] / k] - 1] = arr[i];
            cnt_2[arr[i] / k] --;
        }
        //  ans拷贝回arr
        idx = 0;
        for (int i = left; i <= right; i++) {
            arr[i] = ans[idx++];
        }
    }

}