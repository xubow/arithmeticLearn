package monotonicQueueAndStack;

import sort.util.ArrUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenyves
 * @description: (单调栈)
 *
 * 用于求距离最近的大小值
 *
 * @date 2025/9/11 14:03
 * @since JDK 1.8
 */
public class MonotonicStack {


    public static void main(String[] args) {
        int[] arr = ArrUtil.randomArr(10);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // 如果栈顶元素大于新值，将栈顶推出 求右边的最近小值
            // 如果栈顶元素小于新值，将栈顶推出 求右边的最近大值
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                // arr[i] 就是 离arr[stack.peek()]最近的右边的小于值
                stack.pop();
            }
            stack.add(i);
        }

        stack.clear();

        // 反向入栈 求左边的最近大小值
        for (int i = arr.length-1; i >=0; i--) {
            // 如果栈顶元素大于新值，将栈顶推出 求左边的最近小值
            // 如果栈顶元素小于新值，将栈顶推出 求左边的最近大值
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                // arr[i] 就是 离arr[stack.peek()]最近的左边的小于值
                stack.pop();
            }
            stack.add(i);
        }
    }
}