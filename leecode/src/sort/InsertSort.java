package sort;

import sort.util.ArrUtil;

/**
 * @author chenyves
 * @description: (插入排序)
 * 思路：
 * 记录一个未排序区
 * 遍历数组未排序区，依次插队往前排，直到前面没有更小值
 *
 * @date 2025/8/8 08:49
 * @since JDK 1.8
 */
public class InsertSort {

    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            int[] arr = ArrUtil.randomArr(10);
            ArrUtil.printArr(arr);
            sort(arr);
            ArrUtil.printArr(arr);
            System.out.println(ArrUtil.check(arr));
            i ++;
            System.out.println("---------");
        }

        i =0;
        while (i < 10) {
            int[] arr = ArrUtil.randomArr(10);
            ArrUtil.printArr(arr);
            unsupervisedSort(arr);
            ArrUtil.printArr(arr);
            System.out.println(ArrUtil.check(arr));
            i ++;
            System.out.println("---------");
        }
    }


    /**
     * 无监督的优化排序方法
     * 正常的插入排序在将元素往前插入的过程中，会判断是否下标大于0为了防止数组下标越界
     * 如果提前先把边界值确定后，这个边界判断的条件就可以忽略了
     * 在正常的插入排序中，边界判断的次数为O(n2)， 但如果提前确定边界（确定最小值）只要O(n)次操作
     * 少了一个量级的操作
     * @param arr
     */
    public static void unsupervisedSort(int[] arr) {
        int idx = 0;
        // 提前找到最小值下标
        for (int i = 1;i< arr.length; i++) {
            if (arr[i] < arr[idx]) {
                idx = i;
            }
        }

        // 将最小值放在第一个
        while (idx>0) {
            ArrUtil.swap(arr, idx, idx-1);
            idx --;
        }

        for (int i = 1; i < arr.length; i++) {
            int index = i;
            while (arr[index] < arr[index -1]) {
                ArrUtil.swap(arr, index, index-1);
                index--;
            }
        }
    }

    public static void sort(int[] arr) {
        // 第一个元素不用调整位置 所以从第二个元素开始
        for (int i = 1; i < arr.length; i++) {
            // i作为未排序区的最开始位置 但需要往前交换的操作模拟插入
            // 所以需要一个新指针
            int idx = i;
            while (idx > 0 && arr[idx] < arr[idx-1]) {
                ArrUtil.swap(arr, idx, idx-1);
                idx --;
            }
        }
    }


}