package sort;

import sort.util.ArrUtil;

/**
 * @author chenyves
 * @description: (快速排序)
 * 思路：
 *  step1: 选定一个基准值（一般是数组第一个元素，也可以是最后一个）
 *  step2: 定义左右边界(l, r), 假设选第一个元素arr[l]作为基准值，用额外变量tmp记录这个基准值，
 *  step3: 从右边界开始遍历，直到一个数arr[r--]比基准值小
 *  step4: 将arr[r]放到arr[l]的位置，
 *  step5: 然后从左边开始找比基准值大的数，l++
 *  step6: 将arr[l] 放到arr[r]位置
 *  step7: 直到l=r， 将基准值放在arr[l]的位置
 *  step8: 以上一个过程就确定了基准值的确切位置，之后就将基准值左右两边的范围进行递归，每次确定基准值位置
 *
 * @date 2025/8/12 08:42
 * @since JDK 1.8
 */
public class QuickSort_1 {

    public static void main(String[] args) {
//        int[] arr = ArrUtil.randomArr(20);
        int[] arr = new int[]{99, 20, 79, 31, 23, 62, 62, 18, 60, 6 ,46, 53, 52, 32, 25, 54, 55, 20, 39, 43};
        ArrUtil.printArr(arr);
        System.out.println("-----");
        new QuickSort_1().sort(arr, 0, arr.length-1);
        ArrUtil.printArr(arr);
        ArrUtil.check(arr);
    }

    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right;
        int tmp = arr[l];
        while (l < r) {
            // 从右边遍历找到比基准值小的数
            while (l < r && arr[r] >= tmp) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l ++;
            }
            // 从左边遍历找到比基准值大的数
            while (l < r && arr[l] <= tmp) {
                l ++;
            }
            if (l < r) {
                arr[r--] = arr[l];
            }
        }
        // l=r 确定基准值位置，此时(left, l) ，(l+1, right)两个区域就是分别比基准值小和大的两个区域
        arr[l] = tmp;
        sort(arr, left, l);
        sort(arr, l+1, right);
    }
}