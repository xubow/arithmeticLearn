package monotonicQueueAndStack;

import java.util.Stack;

/**
 * @author chenyves
 * @description: (接雨水)
 * https://leetcode.cn/problems/trapping-rain-water/
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * @date 2025/9/13 09:38
 * @since JDK 1.8
 */
public class Trap {




    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int smallH = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) continue;
                // 当下一个柱子比较高的时候，才能接雨水
                // 每次弹出中间的一个矮的柱子，就需要计算一下增量雨水
                // 也可以用单调栈的作用来思考，增量的雨水就是离当前柱子最近的那个比他高的柱子，两者的高度差*两者的距离
                ans += (Math.min(height[i], height[stack.peek()]) - smallH) * (i - stack.peek() -1);
            }
            stack.add(i);
        }
        return ans;
    }

}