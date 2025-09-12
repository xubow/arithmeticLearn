package DisjointSet;

/**
 * @author chenyves
 * @description: (并查集优化)
 *
 * 1. 带秩优化
 *  为了避免多个点连通后，形成单链表的形式，此时会大大拉低查询的效率，
 *  所以在合并的时候，将子节点少的根节点连向子节点多的根节点
 *
 * 2. 路径压缩
 *  优化思路：压缩树的高度
 *  容易想到将所有节点都直接作为根节点的子节点，但这样做，在merge的时候就和quickfind的染色思想一致了
 *  解决方案： 在find根节点的方法中(不是在merge的时候，每次都遍历所有子节点，改变指向)，
 *      查找的同时，便将该点指向根节点，这样均摊时间复杂度为O(1)；
 *
 * @date 2025/9/10 12:08
 * @since JDK 1.8
 */
public class OptimizeQuickUnion {

    int n;
    // 记录每个下标对应的父节点
    int[] fa;
    // 记录每个下标作为头节点时子树的节点数量
    int[] size;

    public OptimizeQuickUnion(int n) {
        this.n = n;
        fa = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            // 初始化 每个下标的父节点就是自己
            fa[i] = i;
            // 初始化 每个下标作为根节点时子节点数量为1
            size[i] = 1;
        }
    }

    /**
     * 找指定下标对应的根节点  路径压缩优化
     * @param i
     * @return
     */
    int find(int i) {
        // 普通写法，递归返回根节点
//        return fa[i] == i ? i : find(fa[i]);
        // 路径压缩  查找根节点的同时，将i指向根节点
        return fa[i] = (fa[i] == i ? i : find(fa[i]));
    }

    /**
     * 合并ab两个节点  按秩优化
     * @param a
     * @param b
     * @return
     */
    int merge(int a, int b) {
        // a根节点
        int aa = find(a);
        // b根节点
        int bb = find(b);
        // 本来就是连通的 不做处理
        if (aa == bb) return 0;
        // 按秩优化
        if (size[aa] < size[bb]) {
            // aa的子节点少 就将aa指向bb
            fa[aa] = bb;
            // 指向之后 不要忘记更新根节点的子节点数量
            size[bb] += size[aa];
        } else {
            // bb的子节点少 就将bb指向aa
            fa[bb] = aa;
            size[aa] += size[bb];
        }
        return 1;
    }
}