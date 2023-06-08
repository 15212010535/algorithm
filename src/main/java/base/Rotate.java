package base;

/**
 * 旋转图像：先转置，然后反转每一个行
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        // 转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 每一行进行反转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < (matrix.length >> 1); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }
}
