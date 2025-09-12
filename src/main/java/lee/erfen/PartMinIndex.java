package lee.erfen;

import java.util.Arrays;

/**
 * @Author Yves
 * @Data 2023/4/4 下午3:54
 * @Desc  二分查找局部最小值
 */
public class PartMinIndex extends ArrBase {
    public static void main(String[] args) {
        System.out.println(findPartMinIndex(unsortArr));
    }

    //arr无序
    private static int findPartMinIndex(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[arr.length-1] < arr[arr.length-2]) {
            return arr[arr.length-1];
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = L + ((R-L)>>1);
            if (arr[mid] < arr[mid+1]) {
                R = mid;
            } else if(arr[mid] > arr[mid-1]) {
                L = mid;
            } else {
                //arr[mid]<=arr[mid+1] && arr[mid]>=arr[mid-1]
                return mid;
            }
        }
        return 0;
    }
}
