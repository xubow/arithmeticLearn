package DisjointSet;

/**
 * @author chenyves
 * @description: (并查集 quick-find算法)
 *
 *  基于染色思想，将连通的一组元素放在同一个集合中，统一颜色
 *
 *
 * @date 2025/9/9 08:35
 * @since JDK 1.8
 */
public class QuickFind {
    // 定义n个数
    int n;
    // color[i]模拟代表第i个数的颜色
    int[] color;

    public QuickFind(int n) {
        this.n = n;
        this.color = new int[n];
        // 初始化模拟赋色
        for (int i = 0; i < n; i++) {
            this.color[i] = i;
        }
    }

    /**
     * 判断
     * @param a
     * @param b
     * @return
     */
    boolean find(int a, int b) {
        return color[a] == color[b];
    }

    /**
     * 联通ab两个数
     * 将a颜色的所有数都变为b的颜色 （即 将ab两个颜色相同的集合合并为一个）
     * @param a
     * @param b
     */
    void merge(int a, int b) {
        int aa = color[a];
        int bb = color[b];
        for (int i = 0; i < color.length; i++) {
            if (color[i] == aa) {
                color[i] = bb;
            }
        }
    }

}