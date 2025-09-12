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
package lee.stringAndArray;

/**
 * @description: (最长回文串)
 * @author chenyves
 * @date 2024/7/16 10:27 PM
 * @since JDK 1.8
 */
public class LargestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new LargestPalindrome().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        // 长度小于2 自己就是回文串
        if (n < 2)
            return s;

        // 定义dp[i][j] s在i位置和j位置 是否是回文串
        boolean[][] dp = new boolean[n][n];


        char[] arr = s.toCharArray();
        // 记录回文串最大长度
        int max = 1;
        // 记录回文串开始位置
        int start = 0;
        int end = 0;
        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (arr[l] == arr[r] && (dp[l + 1][r - 1] || r - l <= 2 )) {
                    dp[l][r] = true;
                    if (r - l + 1 > max) {
                        max =  r - l + 1;
                        start = l;
                        end = r;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}