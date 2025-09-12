package tree;

import tree.model.TreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author chenyves
 * @description: (请在此添加描述)
 * @date 2025/8/5 08:33
 * @since JDK 1.8
 */
public class BigHeapSort {

    public static void main(String[] args) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        int ans;
        System.out.println(ans = queue.poll().intValue());


        BigHeapSort cons = new BigHeapSort();
        int[] arr = cons.createRandomIntArr(10);
        System.out.println("初始数组: " + Arrays.toString(arr));
        int n = arr.length;
        // 每进行一次大根堆 选出一个最大值在arr[0]位置
        // 将arr[0] arr[n-1]位置交换
        // 对arr 0～n-1位置上选出最大值  循环进行n次
        for (int i = n; i>0;i-- ) {
            cons.sort(arr, 0, i);
//            System.out.println("i=" + i + ": " + Arrays.toString(arr));
            cons.swap(arr, 0, i-1);
//            System.out.println("i=" + i + " 交换: " + Arrays.toString(arr));
        }
        System.out.println("排序后： " + Arrays.toString(arr));
    }

    /**
     * 第i节点子树的最大值
     * @param arr
     * @param i
     * @return
     */
    public int sort(int[] arr, int i, int n) {
        if (i >= n) {
            return -1;
        }
        // root left right 三个节点比较大小 然后最大的值给root
        int root = arr[i];
        int left = sort(arr, 2*i +1, n);
        int right = sort(arr, 2*i +2, n);

        if (left >= root) swap(arr, i, 2*i+1);
        root = arr[i];
        if (right >= root) swap(arr, i, 2*i+2);
        root = arr[i];
        return root;
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] =tmp;
    }

    public int[] createRandomIntArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(100);
        }
        return arr;
    }

}