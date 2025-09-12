package lee.Sort;

import lee.erfen.ArrBase;
import org.springframework.util.StringUtils;

/**
 * @Author Yves
 * @Data 2023/4/7 上午10:12
 *
 * 归并排序  两部分分别有序，再合并有序
 */
public class MergeSort extends ArrBase {

    public static void main(String[] args) {
        mergeSort(unsortArr);
        System.out.println(StringUtils.arrayToCommaDelimitedString(new int[][]{unsortArr}));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return arr;
        }
        process(arr, 0, arr.length-1);
        return arr;
    }

    public static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] another = new int[right-left+1];
        int anotherIndex = 0;
        int pl = left;
        int pr = mid +1;
        while (pl<=mid && pr <= right) {
            if (arr[pl] <= arr[pr]) {
                another[anotherIndex++] = arr[pl++];
            } else  {
                another[anotherIndex++] = arr[pr++];
            }
        }
        while(pl <= mid) {
            another[anotherIndex++] = arr[pl ++];
        }
        while (pr <= right) {
            another[anotherIndex++] = arr[pr ++];
        }

        for (int i = 0; i < another.length; i++) {
            arr[left+i] = another[i];
        }

    }
}
