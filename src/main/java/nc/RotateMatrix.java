package nc;

/**
 * 顺时针旋转矩阵
 */
public class RotateMatrix {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n; j >= 0; j--) {
                res[i][n - j] = mat[j][i];
            }
        }
        return res;
    }
}
