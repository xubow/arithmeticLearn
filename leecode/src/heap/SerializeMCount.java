package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenyves
 * @description: (序列M小和)
 * https://oj.haizeix.com/problem/285
 *
 * 给出一个 n∗m的矩阵，每行取一个元素，组成一个包含 n个元素的序列，
 * 一共有 mn种序列，求出序列和最小的前 m个序列的序列和。
 *
 * 输入
 * 2 3 (2行 m=3)
 * 1 2 3
 * 2 2 3
 *
 * 输出
 * 3 3 4
 *
 * 解释： 排列组合有
 * 【1，2】=3 【1，2】=3 【1，3】=4
 * 【2，2】=4 【2，2】=4 【2，3】=5
 * 【3，2】=5 【3，2】=5 【3，3】=6
 * 得出前3个最小和是【3，3，4】
 *
 *
 * @date 2025/8/6 15:43
 * @since JDK 1.8
 */
public class SerializeMCount {

    /**
     * 思路： 计算第N行的m序列小和，假设n-1行的m小和为【s1, s2, s3...sm】
     * 第N行的数据为 [A1,A2...An]
     * 那么第N行的m小和 就是s和A的排列组合中产生
     *
     * 得出前M项的小值，可以使用大根堆，限制堆大小为M即可
     * @param nums
     * @param M
     * @return
     */
    public static int[] serializeMCount(int[][] nums, int M) {
        // 定义两个大根堆
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((o1, o2) -> o2-o1);
        PriorityQueue<Integer> queue2 = new PriorityQueue<>((o1, o2) -> o2-o1);
        PriorityQueue[] queueArr = new PriorityQueue[2];
        // 当前行的m小和
        queueArr[0] = queue1;
        // 前一行的m小和
        queueArr[1] = queue2;
        // 初始化 给前一行的堆添加一个0元素
        queueArr[1].add(0);

        for (int i = 0; i < nums.length; i++) {
            // 当前行
            int[] curLine = nums[i];
            // 小技巧：滚动数组（queueArr[0]和queueArr[1]交替使用）
            // 因为queue数组中就两个元素，所以%2之后，不是0就是1
            int s1 = i%2, s2 = 1-i;
            // s1代表当前行的堆  s2代表前一行的堆
            // 为了方便循环s2中的元素
            int[] s2Arr = new int[queueArr[s2].size()];
            int idx = 0;
            while (!queueArr[s2].isEmpty()) {
                s2Arr[idx ++] = (int)queueArr[s2].poll();
            }
            // 因为s1复用，所以每次进来都要清空
            queueArr[s1].clear();
            // 当前行的值和前一行m小和的值进行排列组合
            for (int num : curLine) {
                for (int preS2 : s2Arr) {
                    int val = num + preS2;
                    // 当前行的堆没满，就直接将和放入
                    // 如果当前行的堆满了 但是和小于大根堆的最大值，说明可以放入，后续将最大值弹出即可
                    if (queueArr[s1].size() < M || (int)queueArr[s1].peek() >= val) {
                        queueArr[s1].add(val);
                    }
                    if (queueArr[s1].size() > M) {
                        queueArr[s1].poll();
                    }
                }
            }

        }
        // 将最后s1输出 因为s1是大根堆，循环弹出是倒叙，题目要求升序
        PriorityQueue queue = queueArr[(nums.length - 1) % 2];
        int[] ans = new int[M];
        int index = M-1;
        while (!queue.isEmpty()) {
            ans[index--] = (int)queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1,2,3};
        int[] n2 = new int[]{2,2,3};
        int[][] nums = new int[][]{n1, n2};
        int[] arr = serializeMCount(nums, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}