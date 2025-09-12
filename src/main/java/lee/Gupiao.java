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

/**
 * @description: (请在此添加描述)
 * @author chenyves
 * @date 2024/7/18 9:18 AM
 * @since JDK 1.8
 */
public class Gupiao {


    public static void main(String[] args) {
        int[] arr = new int[]{2,5,4,6,7,8};
        System.out.println(new Gupiao().process(arr));
    }

    public int process(int[] arr) {
        int maxRes = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int r = i+1;
            while (r < n && arr[r] > arr[i]) {
                maxRes = Math.max(arr[r] - arr[i], maxRes);
                r ++;
            }
        }

        return maxRes;
    }


}