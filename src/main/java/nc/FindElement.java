package nc;

/**
 * 矩阵元素查找
 */
public class FindElement {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int[] result = new int[2];
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                result[0] = row;
                result[1] = col;
                break;
            }
            if (x > mat[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return result;
    }
}
