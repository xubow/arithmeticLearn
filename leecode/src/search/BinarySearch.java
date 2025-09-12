package search;

import sort.MergeSort;
import sort.util.ArrUtil;

/**
 * @author chenyves
 * @description: (二分查找 在一组单调数据中找到一个和指定值k相同的数)
 *
 * 数组： y = f[x] 传入下标x，返回下标x的值y  消耗存储空间
 * 函数： y = f(x) 传入x，返回y     消耗计算时间
 *
 * 二分使用场景（本质上作用于单调函数） ：
 * 1. f(x) 单调函数  e.g. 数组有序非递增或非递减
 * 2. y=f(x)  根据x很容易求的y，但根据y求得x相对比较麻烦
 * 符合这两点就可以使用二分思想
 *
 *
 *
 * @date 2025/8/24 12:08
 * @since JDK 1.8
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{92, 25, 4 ,79, 59, 16, 70, 3, 64, 71, 55};
        ArrUtil.printArr(arr);
        System.out.println("--------");
        new MergeSort().sort(arr, 0, arr.length-1);
        ArrUtil.printArr(arr);
        System.out.println(recurseSearch(arr, 0, arr.length-1, 4));
        System.out.println(whileSearch(arr, 0, arr.length-1, 1));
    }

    /**
     * 递归实现二分
     * @param arr 递增序列
     * @param left
     * @param right
     * @param k
     * @return
     */
    public static int recurseSearch(int[] arr, int left, int right, int k) {
        if (left >= right) {
            if (arr[right] == k) return right;
            else return -1;
        }
        int mid = left + ((right - left) >> 1);
        if (arr[mid] == k) {
            return mid;
        }
        if (arr[mid] < k) {
           return recurseSearch(arr, mid+1, right, k);
        }
        return recurseSearch(arr, left, mid-1, k);
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param k
     * @return
     */
    public static int whileSearch(int[] arr, int left, int right, int k) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == k) return right;
            if (arr[mid] < k) left = mid + 1;
            if (arr[mid] > k) right = mid -1;
        }
        return -1;
    }
}