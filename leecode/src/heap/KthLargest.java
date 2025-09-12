package heap;

import java.util.PriorityQueue;

/**
 * @author chenyves
 * @description: (数据流中的第 K 大元素)
 * https://leetcode.cn/problems/kth-largest-element-in-a-stream/description/
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 *
 * @date 2025/8/5 20:50
 * @since JDK 1.8
 */
public class KthLargest {


    PriorityQueue<Integer> queue;
    int order;

    public KthLargest(int k, int[] nums) {
        if (this.queue == null) {
            this.queue = new PriorityQueue<>();
        }
        this.order = k;
        for (int i = 0;i < nums.length; i++) {
            add(nums[i]);
        }

    }

    public int add(int val) {
        this.queue.add(val);
        if (this.queue.size() > order) {
            queue.poll();
        }
        return queue.peek();
    }

}