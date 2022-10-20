package 刷题.一千;

import java.util.*;

/**
 * 886、可能的二分法
 * 染色发分组，1、2
 */
public class PossibleBipartition {
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        // 1、创建存储
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        // 遍历
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(i, 1, color, g))
                return false;
        }
        return true;
    }

    private static boolean dfs(int curnode, int nowcolor, int[] color, List<Integer>[] g) {
        color[curnode] = nowcolor;
        for (int nextnode : g[curnode]) {
            // 当前已染过色，并且是同一组，在过来染色表示互斥。
            if (color[nextnode] != 0 && color[nextnode] == color[curnode])
                return false;
            // 当前并未染色，则为不喜欢的染相反颜色。
            if (color[nextnode] == 0 && !dfs(nextnode, 3 ^ curnode, color, g))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] dislikes = new int[][]{{1, 2}, {1, 3}, {2, 4}};
        System.out.println(possibleBipartition(4, dislikes));
    }
}

/**
 * 广度优先
 */
class PossibleBipartition2{

    public static boolean possibleBipartition(int n, int[][] dislikes){

        return true;
    }
}































