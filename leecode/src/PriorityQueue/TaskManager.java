package PriorityQueue;

import java.util.*;

/**
 * @author chenyves
 * @description: (设计任务管理器)
 * https://leetcode.cn/problems/design-task-manager/description/?envType=daily-question&envId=2025-09-18
 * @date 2025/9/18 16:13
 * @since JDK 1.8
 */
public class TaskManager {

    public static void main(String[] args) {
        //["TaskManager","add","edit","execTop","rmv","add","execTop"]
//        [[[[1,101,10],[2,102,20],[3,103,15]]],[4,104,5],[102,8],[],[101],[5,105,15],[]]
        List<List<Integer>> init = new ArrayList<>();
        init.add(Arrays.asList(1,101,10));
        init.add(Arrays.asList(2,102,20));
        init.add(Arrays.asList(3,103,15));
        TaskManager manager = new TaskManager(init);
        manager.add(4,104,5);
        manager.edit(102,8);
        System.out.println(manager.execTop());
        manager.rmv(101);
        manager.add(5,105,15);
        System.out.println(manager.execTop());
    }

    class Task {
        Integer userId;
        Integer taskId;
        Integer priority;

        public Task(Integer userId, Integer taskId, Integer priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        public Task() {
        }
    }

    PriorityQueue<Task> queue;

    public TaskManager(List<List<Integer>> tasks) {
        queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (Objects.equals(o1.priority, o2.priority)) {
                    return o2.taskId - o1.taskId;
                }
                return o2.priority - o1.priority;
            }
        });
        for (List<Integer> task : tasks) {
            Task t = new Task();
            if (task.isEmpty()) {
                continue;
            }
            if (task.size() == 1) {
                t.userId = task.get(0);
            }
            if (task.size() == 2) {
                t.userId = task.get(0);
                t.taskId = task.get(1);
            }
            if (task.size() == 3) {
                t.userId = task.get(0);
                t.taskId = task.get(1);
                t.priority = task.get(2);
            }
            queue.add(t);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        queue.add(t);
    }

    public void edit(int taskId, int newPriority) {
        Task needEdit = null;
        // 遍历队列的时间可能很久，所以可以再维护一个hash表，建立taskId和最新的priority的关系，
        // 在弹出操作的时候进行判断是否是最新的task信息,不用在编辑的时候遍历全部
        for (Task next : queue) {
            if (next.taskId == taskId) {
                needEdit = next;
            }
        }
        if (needEdit != null) {
            Task newT = new Task(needEdit.userId, needEdit.taskId, newPriority);
            queue.remove(needEdit);
            queue.add(newT);
        }
    }

    public void rmv(int taskId) {
        queue.removeIf(p -> p.taskId == taskId);
    }

    public int execTop() {
        if (queue.isEmpty()) {
            return -1;
        }
        Task peek = queue.peek();
        queue.poll();
        return peek.userId;
    }

}