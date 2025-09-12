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
package lee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author chenyves
 * @description: (请在此添加描述)
 * @date 2024/7/18 10:15 AM
 * @since JDK 1.8
 */
public class QueueTest {

    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    ;
    private int[] arr;
    private int index;

    public QueueTest(int length) {
        arr = new int[length];
    }

    public static void main(String[] args) {

    }

    public void distinctM(int[] arr1, int[] arr2) {
        HashSet set = new HashSet();
        for (int i : arr2) {
            set.add(i);
        }
        for (int i = 0; i < arr1.length; i++) {
            if (set.contains(arr1[i])) {
                 arr1[i] = -1;
            }
        }
    }


    public void add(int num) {
        if (index == 0) {
            arr[arr.length - 1] = num;
            index++;
        } else {
            arr[arr.length - index - 1] = num;
        }
    }

    public int pop() {
        if (index == 0) {
            return 0;
        }

        return arr[arr.length - 1];
    }

}