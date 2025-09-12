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
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @description: (请在此添加描述)
 * @author chenyves
 * @date 2024/7/23 1:36 PM
 * @since JDK 1.8
 */
public class BinarySearch {

    public static void main(String[] args) throws InterruptedException {
         //int[] arr = new int[]{1,2,3,4,5,6,7,8};
        new BinarySearch().runTest();
    }


    public int bs(int[] arr , int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else if (target > arr[mid]) {
                l = mid + 1;
            }
        }
        System.out.println("12323123");
        System.out.println("343434");
        return -1;
    }


    public void runTest() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        List<Thread> ts = new ArrayList<>();
        for(int i = 0; i < 10;i++) {
            int finalI = i;
            ts.add(new Thread(() -> {
                System.out.println("线程"+ finalI + "准备好了");
                latch.countDown();
            }));
        }
        latch.await();

        System.out.println("比赛开始");
        for (Thread t : ts) {
            t.start();
            System.out.println("线程"+t.getName()+"耗时"+new Random().nextLong());
        }


    }

}