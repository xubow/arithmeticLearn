package DisjointSet;

/**
 * @author chenyves
 * @description: (省份数量)
 * https://leetcode.cn/problems/number-of-provinces/description/
 *
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 *
 * @date 2025/9/11 11:21
 * @since JDK 1.8
 */
public class NumsOfProvince {

    class DisjointSet {
        int[] fa;

        public DisjointSet(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int i) {
            return fa[i] = (fa[i] == i ? i : find(fa[i]));
        }

        void merge(int a, int b) {
            fa[find(a)] = find(b);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        DisjointSet union = new DisjointSet(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1)
                    union.merge(i, j);
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (union.find(i) == i) ans ++;
        }
        return ans;
    }


}