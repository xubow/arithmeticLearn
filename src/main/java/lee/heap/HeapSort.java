/**
 * Copyright (c) 2024, ShangHai HOWBUY INVESTMENT MANAGEMENT Co., Ltd.
 * All right reserved.
 * <p>
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF HOWBUY INVESTMENT
 * MANAGEMENT CO., LTD.  THE CONTENTS OF THIS FILE MAY NOT BE DISCLOSED
 * TO THIRD PARTIES, COPIED OR DUPLICATED IN ANY FORM, IN WHOLE OR IN PART,
 * WITHOUT THE PRIOR WRITTEN PERMISSION OF HOWBUY INVESTMENT MANAGEMENT
 * CO., LTD.
 */
package lee.heap;

import java.util.Arrays;

/**
 * @description: (堆排序)
 * @author chenyves
 * @date 2024/7/12 9:58 AM
 * @since JDK 1.8
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,6,3,7,9,8};
        HeapSort sort = new HeapSort();
        sort.heapSortMethod(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }



    void heapSortMethod(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
            // 大根堆的第一个数和最后一个数做交换 （这样一来 数组末尾的数就一定是最大值）
        }
    }

    // 入堆操作  index为 插入的是第几个数
    void heapInsert(int[] arr, int index) {
        //(index-1)/2  父节点  (0-1)/2 =0
        // 和父节点做比较
        while (arr[index] > arr[(index-1)/2]) {
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    // index 代表从某个下标开始进行堆化  heapSize代表数组长度，用来判断是否越界
    void heapify(int[] arr, int index , int heapSize) {
        // 数组下标从0开始  左孩子的下标就是index*2+1  右孩子下标就是index*2+2
        int left = index * 2 + 1;
        int right = left + 1;
        while(left < heapSize) {
            // 左右孩子取最大值
            // 右孩子如果越界 代表只有左孩子
            int large = arr[right] < heapSize && arr[left] <= arr[right] ?
                    right :  left;
            // index上数如果比左右孩子中最大值还要大  那么large就是index位置
            if (arr[index] > arr[large]) {
                 large = index;
            }
            if (large == index) {
                //父节点比左右孩子节点上的数都要大 就结束
                break;
            }
            //如果父节点值小于子节点值
            //父子节点交换最大值给父节点
            swap(arr, large, index);
            //index变为子节点中最大值的下标
            index = large;
            //继续循环判断large下标位置上 新替换的值和他所属的左右孩子上的最大值做比较
            left = index * 2 + 1;
        }
    }

    void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }


}