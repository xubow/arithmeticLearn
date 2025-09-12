package sort.util;

import java.util.Random;

/**
 * @author chenyves
 * @description: (请在此添加描述)
 * @date 2025/8/7 16:38
 * @since JDK 1.8
 */
public class ArrUtil {

    static Random random = new Random();

    /**
     * 随机生产100以内的int数组
     * @param n
     * @return
     */
    public static int[] randomArr(int n) {
        return randomArr(n, 100);
    }

    public static int[] randomArr(int n, int bound) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }


    public static void printArr(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i : arr) {
            builder.append(i).append(" ");
        }
        System.out.println(builder);
    }


    public static boolean check(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}