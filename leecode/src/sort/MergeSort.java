package sort;

import sort.util.ArrUtil;

/**
 * @author chenyves
 * @description: (归并排序)
 * @date 2025/8/8 16:46
 * @since JDK 1.8
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int i = 0;
        while (i < 10) {
            int[] arr = ArrUtil.randomArr(10);
            ArrUtil.printArr(arr);
            mergeSort.sort(arr, 0, arr.length-1);
            ArrUtil.printArr(arr);
            System.out.println(ArrUtil.check(arr));
            System.out.println("---------");
            i ++;
        }

    }


    public void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right-left) >>1);
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, right);
    }

    /**
     *  [5, 3, 1, 4, 2] ->
     *  [5, 3, 1]  [4, 2]
     * @param arr
     * @param left
     * @param right
     */
    public void merge(int[] arr, int left, int right) {
        int[] ans = new int[right-left+1];
        int mid = left + ((right-left) >>1);
        int l = left;
        int r = mid +1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                ans[index ++ ] = arr[l++];
            } else {
                ans[index ++] = arr[r++];
            }
        }
        while (l <= mid) {
            ans[index ++] = arr[l ++];
        }

        while (r <= right) {
            ans[index ++] = arr[r ++];
        }

        index = 0;
        for (int i = left; i <= right; i++) {
            arr[i] = ans[index ++];
        }
    }
}