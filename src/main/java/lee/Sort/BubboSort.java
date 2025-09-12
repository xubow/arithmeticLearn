package src.main.java.lee.Sort;

import org.springframework.util.StringUtils;

/**
 * @Author Yves
 * @Data 2023/4/3 下午3:04
 */
public class BubboSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,4,2,4,1};
        bubboSort(arr);
        System.out.println(StringUtils.arrayToCommaDelimitedString(new int[][]{arr}));
    }

    public static void bubboSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length -1; i >= 0; i -- ) {
            for(int j = 0; j < i; j ++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
