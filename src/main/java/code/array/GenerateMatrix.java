package code.array;

/**
 * 螺旋矩阵II
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int[][] res = new int[n][n];
        int num = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            if (++top > bottom)
                break;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            if (--right < left)
                break;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            if (--bottom < top)
                break;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            if (++left > right)
                break;
        }
        return res;
    }
}
