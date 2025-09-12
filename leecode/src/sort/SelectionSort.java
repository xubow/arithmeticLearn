package sort;

import sort.util.ArrUtil;

/**
 * @author chenyves
 * @description: (选择排序) 时间复杂度O(n2)
 *
 * 思路：
 *  将数组分为已排序区和未排序区
 *  1。 每次遍历未排序区，找到最小值，
 *  2. 和未排序区的第一个位置做交换
 *
 * @date 2025/8/7 16:38
 * @since JDK 1.8
 */
public class SelectionSort {


    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            int[] arr = ArrUtil.randomArr(10);
            ArrUtil.printArr(arr);
            sort(arr, 0, arr.length-1);
            ArrUtil.printArr(arr);
            System.out.println(ArrUtil.check(arr));
            i ++;
            System.out.println("---------");
        }
    }

    /**
     * 指定边界内进行排序
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr, int left, int right) {
        // 最后一个数不用排序 所以i<right即可
        for (int i =left; i<right; i++) {
            int idx = i;
            // 找到未排序区最小值的下标idx
            for (int j = i + 1; j <= right; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            // 交换
            swap(arr, i, idx);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}