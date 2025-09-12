package lee.queueAndStack;

/**
 * @Author Yves
 * @Data 2023/4/6 下午2:38
 * 数组实现队列和栈
 */
public class ArrayQueueAndStack {

    Object[] arrayQueue;
    int pushIndex;
    int pollIndex;
    int size;

    int index;

    public ArrayQueueAndStack() {
        this.arrayQueue = new Object[8];
        this.pushIndex = 0;
        this.pollIndex = 0;
        this.index = 0;
        this.size = 0;
    }

    //数组实现queue比较麻烦 尾进头出 固定长度数组变成环状性质
    // pollIndex 追赶pushIndex，引入size，解耦两者临界值判断比较
    public void pushQueue(Object obj) {
        if (size == arrayQueue.length) {
            System.out.println("queue 满了");
            pushIndex = 0;
            return;
        }

        size ++;
        arrayQueue[pushIndex ++] = obj;
    }

    public Object pollQueue() {
        if (size == 0) {
            System.out.println("queue 为空");
            pollIndex = 0;
            return null;
        }
        size --;
        return arrayQueue[pollIndex ++];

    }


    public void pushStack(Object obj) {
         //index记录下个可以存放元素位置
        if (index == arrayQueue.length) {
            System.out.println("stack 满了");
            return;
        }
        arrayQueue[index] = obj;
        index ++;
    }

    public Object pollStack() {
        if (index == 0) {
            System.out.println("stack 为空");
            return null;
        }
        return arrayQueue[-- index];
    }

}
