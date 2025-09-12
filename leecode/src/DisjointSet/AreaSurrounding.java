package DisjointSet;

/**
 * @author chenyves
 * @description: ( 被围绕的区域)
 * https://leetcode.cn/problems/surrounded-regions/description/
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
 * 通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值
 *
 * 思路： 设想整个矩阵被一圈‘o’包围，，那么在边上的‘o’都会与最外圈的‘o’连通，而被‘x’包围的则不会与外圈连通
 *
 * @date 2025/9/10 16:58
 * @since JDK 1.8
 */
public class AreaSurrounding {

    class UnionSet{
        int[] fa;

        public UnionSet(int n) {
            // 大小设置为n+1 是为了留出下标0，用于代表外圈‘o’的根节点
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


    public void solve(char[][] board) {
        int m = board.length; int n = board[0].length;
        UnionSet union = new UnionSet(m * n + 1);
        // 将m*n矩阵(n行， m列)模拟成一个坐标轴 假设左下角为(0, 0)
        // 将坐标(x, y)映射成下标 index = x + m*y + 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i + m*j + 1;
                if (board[i][j] == 'O') {
                    // 如果o在边上，则一定会与模拟的最外圈连通
                    if (i == 0 || i == m-1 || j==0 || j == n-1) {
                        union.merge(index, 0);
                    }
                    // 相隔的o之间，只要判断竖横中各自一个方向是否相邻即可 比如判断左边和上边即可
                    // A与B相邻： A节点的右边和上边 等价于 B的左边和下边
                    // 是否要与右边的o进行merge
                    if (i+1 < m && board[i + 1][j] == 'O') {
                        union.merge(index + 1, index);
                    }
                    // 是否要与上面的o进行merge
                    if (j+1<n && board[i][j + 1] == 'O') {
                        union.merge(index + m, index);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i + m * j + 1;
                // 如果节点没有与最外圈的o连通，则表明是被x包围了
                if (board[i][j] == 'O' && union.find(index) != union.find(0)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}