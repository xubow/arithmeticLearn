package DisjointSet;

/**
 * @author chenyves
 * @description: (岛屿数量)
 * https://leetcode.cn/problems/number-of-islands/description/
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 * @date 2025/9/11 10:58
 * @since JDK 1.8
 */
public class NumsOfIsland {

    class DisjointSet {
        int[] fa;

        public DisjointSet(int n) {
            this.fa = new int[n + 1];
            for (int i = 0; i <= n; i++) {
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

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DisjointSet join = new DisjointSet(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i + m * j + 1;
                if (grid[i][j] == '0') {
                    join.merge(index, 0);
                } else {
                    if (i + 1 < m && grid[i+1][j] == '1') join.merge(index+1, index);
                    if (j + 1 < n && grid[i][j+1] == '1') join.merge(index+m, index);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i + m * j + 1;
                // 查找根节点为‘1’的个数
                if (grid[i][j] == '1' && join.find(index) == index) ans ++;
            }
        }
        return ans;
    }
}