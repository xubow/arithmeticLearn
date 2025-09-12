package DisjointSet;

/**
 * @author chenyves
 * @description: (并查集 quick-union)
 *
 * quick-find方法中染色思想的合并操作复杂度高，每次都要将一整个同色集合改成目标值颜色
 * union方法则是通过间接的指向来解决是否相通，类似于记录父节点，寻找根节点，最后判断根节点是否同一个
 *
 * @date 2025/9/9 08:35
 * @since JDK 1.8
 */
public class QuickUnion {

    // 定义一个fa数组 fa[i] 代表i节点的父节点
    int[] fa;

    // 定义n个节点
    int n;

    public QuickUnion(int n) {
        this.n = n;
        this.fa = new int[n];
        for (int i = 0; i < n; i++) {
            // 初始化自己的父节点是自己
            fa[i] = i;
        }
    }

    /**
     * 找到当前节点对应的根节点
     * @param n
     * @return
     */
    int find(int n) {
        // 父节点是自己 代表当前数就是根节点
        if (fa[n] == n) return n;
        return find(fa[n]);
    }

    /**
     * 连通两个节点
     * @param a
     * @param b
     * @return
     */
    int merge(int a, int b) {
        // a的根节点
        int ra = find(a);
        // b的根节点
        int rb = find(b);
        // 如果ab已经连通，则结束
        if (ra == rb) return 0;
        // 将a父节点绑定为b
        fa[a] = b;
        return 1;
    }

}